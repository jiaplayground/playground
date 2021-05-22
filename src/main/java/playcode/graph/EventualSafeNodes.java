package playcode.graph;

import java.util.*;

class EventualSafeNodes {
    private static int FIRST_VISITED = 1;
    private static int NO_CYCLE = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] states = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null) {
                safeNodes.add(i);
                continue;
            }
            if (!isCycle(graph, i, states)) {
                states[i] = NO_CYCLE;
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean isCycle(int[][] graph, int from, int[] states) {
        if (states[from] == NO_CYCLE) return false;
        if (states[from] == FIRST_VISITED) return true;
        states[from] = FIRST_VISITED;
        for (int to : graph[from]) {
            if (isCycle(graph, to, states)) {
                return true;
            }
        }
        states[from] = NO_CYCLE;
        return false;
    }

    public static void main(String[] args) {
        EventualSafeNodes e = new EventualSafeNodes();
        e.eventualSafeNodes(new int[][]{{}});
    }

}
