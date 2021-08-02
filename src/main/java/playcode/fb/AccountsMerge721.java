package playcode.fb;

import java.util.*;

public class AccountsMerge721 {

    private int[] arr;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        arr = new int[1001];
        for (int i = 1; i < 1001; i++) arr[i] = i;
        Map<String, Integer> nameIdxs = new HashMap<>();
        Map<String, String> names = new HashMap<>();

        int idx = 0;
        for (List<String> account : accounts) {
            idx++;
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                names.put(email, account.get(0));
                if (nameIdxs.containsKey(email)) {
                    union(idx, nameIdxs.get(email));
                } else {
                    nameIdxs.put(email, idx);
                }

            }
        }
        Map<Integer, List<String>> idxEmails = new HashMap<>();
        nameIdxs.entrySet().forEach(e ->
                idxEmails.computeIfAbsent(find(e.getValue()), x -> new ArrayList<>()).add(e.getKey()));
        List<List<String>> result = new ArrayList<>();
        for (List<String> one : idxEmails.values()) {
            Collections.sort(one);
            String name = names.get(one.get(0));
            one.add(0, name);
            result.add(one);
        }
        return result;
    }

    void union(int p, int q) {
        p = find(p);
        q = find(q);
        arr[p] = q;
    }

    private int find(int p) {
        while (arr[p] != p) {
            p = arr[p];
        }
        return p;
    }


}

