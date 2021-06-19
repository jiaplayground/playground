package playcode.aoa;

import java.util.*;
public class AccountsMerge721 {
    int[] parent = new int[1001];
    String[] names = new String[1001];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < 1001; i++) {
            parent[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (List<String> list : accounts) {
            names[idx] = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                Integer seen = map.get(list.get(i));
                map.put(list.get(i), idx);
                if (seen != null) {
                    union(idx, seen);
                }
            }
            idx++;
        }
        //get result
        Map<Integer, Set<String>> result = new HashMap<>();
        map.entrySet().forEach(e ->
                result.computeIfAbsent(find(e.getValue()), x -> new HashSet<>())
                        .add(e.getKey())
        );
        List<List<String>> out = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> e : result.entrySet()) {
            List<String> list = new ArrayList<>(e.getValue());
            Collections.sort(list);
            list.add(0, names[e.getKey()]);
            out.add(list);
        }
        return out;
    }
    void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 != p2) {
            parent[p2] = p1;
        }
    }
    int find(int c) {
        while (c != parent[c]) {
            c = parent[c];
        }
        return c;
    }
}
