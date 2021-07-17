package playcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class LargestColorValueGraph1857 {

    public int largestPathValue(String colors, int[][] edges) {
        final int N = colors.length();
        List<Integer>[] graph = new List[N];
        int[] degrees = new int[N];
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            degrees[to]++;
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }
            graph[from].add(to);
        }
        if (hasCycle(graph, degrees)) {
            return -1;
        }
        char[] colorArray = colors.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : colorArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<int[]> colorList =
                map.entrySet().stream().filter(e -> e.getValue() > 1)
                        .map(e -> new int[]{e.getKey(), e.getValue()}).sorted((a, b) -> b[1] - a[1])
                        .collect(Collectors.toList());

        int max = 1;
        for (int[] color : colorList) {
            if (color[1] <= max) {
                continue;
            }
            Integer[] mem = new Integer[N];
            for (int root = 0; root < N; root++) {
                if (degrees[root] == 0) {

                    max = Math.max(max, dfs(graph, colorArray, root, (char) color[0], mem));
                }
            }
        }
        return max;
    }

    private int dfs(List<Integer>[] graph, char[] colors, int root, char color, Integer[] mem) {
        if (mem[root] != null) {
            return mem[root];
        }
        if (graph[root] == null) {
            return colors[root] == color ? 1 : 0;
        }
        int count = 0;
        for (int next : graph[root]) {
            count = Math.max(count, dfs(graph, colors, next, color, mem));
        }
        count = (colors[root] == color ? 1 : 0) + count;
        mem[root] = count;
        return count;
    }

    private boolean hasCycle(List<Integer>[] graph, int[] degree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int from = q.poll();
            if (graph[from] != null) {
                for (int to : graph[from]) {
                    degree[to]--;
                    if (degree[to] == 0) {
                        q.offer(to);
                    }
                }
            }
        }
        for (int d : degree) {
            if (d > 0) {
                return true;
            }
        }
        return false;
    }


}
