package playcode.fb;

import java.util.*;

/**
 *         //[[1,2],[0,2],[0,1]]
 *         dfs(0)
 *           dfs(1)
 *                dfs(0) //visited
 *                dfs(2)
 *                    dfs(0) //visited
 *                    dfs(1) //visited
 *           dfs(2)
 */


public class GraphBipartite785 {
   // You can just use default value 0 for non-colored nodes and alternate between 1 and -1. Code becomes slightly more concise and faster

    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0 && !validColor(g, colors, 1, i))
                return false;
        return true;
    }

    boolean validColor(int[][] g, int[] colors, int color, int node) {
        if (colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for (int adjacent : g[node])
            if (!validColor(g, colors, -color, adjacent))
                return false;
        return true;
    }




    private static final int GROUP_A = 0;
    private static final int GROUP_B = 1;
    public boolean isBipartite_My(int[][] graph) {
        Map<Integer, Integer> sets = new HashMap<>();
        //[[1,2],[0,2],[0,1]]
        int size = graph.length;
        Set<Integer> visited = new HashSet<>();
        for(int from =0; from < size; from++){
            if(!visited.contains(from)){
                visited.add(from);
                sets.put(from, GROUP_A);
                if(!dfs(from, graph, visited, sets)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int from, int[][] graph, Set<Integer> visited, Map<Integer, Integer> sets) {
        for (int to : graph[from]) {
            if (sets.get(from) == sets.get(to)) {
                return false;
            }
            if (visited.add(to)) {
                if(!sets.containsKey(to)) {
                    sets.put(to, (sets.get(from) + 1) % 2);
                }
                if (!dfs(to, graph, visited, sets)) {
                    return false;
                }
            }
        }
        return true;
    }
}
