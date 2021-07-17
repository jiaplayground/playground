package playcode.dd;

import java.util.*;
import java.util.stream.Stream;

public class AlienDictionary {
    /**
     * Input：["wrt","wrf","er","ett","rftt"]
     * Output："wertf"
     * "twfre"
     */
    public String alienOrder(String[] words) {
        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }
        Map<Character, Set<Character>> graph = buildGraph(words);
        Map<Character, Integer> indegrees = new HashMap<>();
        for (char from : graph.keySet()) {
            charSet.add(from);
            for (char to : graph.get(from)) {
                indegrees.put(to, indegrees.getOrDefault(to, 0) + 1);
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : charSet) {
            if (!indegrees.containsKey(c)) {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            List<Character> oneLayer = new ArrayList<>(q);
            q.clear();
            Collections.sort(oneLayer);
            for (char from : oneLayer) {
                sb.append(from);
                for (char to : graph.getOrDefault(from, new HashSet<>())) {
                    indegrees.put(to, indegrees.get(to) - 1);
                    if (indegrees.get(to) == 0) {
                        q.offer(to);
                    }
                }
            }
        }
        String result = sb.toString();
        if (result.length() == charSet.size()) {
            return result;
        }
        return "";
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        String pre = words[0];
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            for (int j = 0; j < Math.min(pre.length(), curr.length()); j++) {
                if (pre.charAt(j) != curr.charAt(j)) {
                    graph.computeIfAbsent(pre.charAt(j), e -> new HashSet<>()).add(curr.charAt(j));
                    break;
                }
            }
            pre = curr;
        }
        return graph;
    }

}
