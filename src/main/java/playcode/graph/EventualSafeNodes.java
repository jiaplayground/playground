package playcode.graph;

import java.util.*;

class EventualSafeNodes {
    //We define a starting node to be safe if we must eventually walk to a terminal node
    private static int FIRST_VISIT_IN_THIS_BRANCH = 1;
    private static int LEAD_TO_END = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] states = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isCycle(graph, i, states)) {
                states[i] = LEAD_TO_END; //should not label to state CYCLE
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean isCycle(int[][] graph, int from, int[] states) {
        if (states[from] == LEAD_TO_END) return false;
        if (states[from] == FIRST_VISIT_IN_THIS_BRANCH) return true;
        states[from] = FIRST_VISIT_IN_THIS_BRANCH;
        for (int to : graph[from]) {
            /** 0<->1->2  // when it goes to Node B-> it will dfs(A), dfs(C);
             */
            if (isCycle(graph, to, states)) {
                return true;
            }
        }
        states[from] = LEAD_TO_END;
        return false;
    }

    public static void main(String[] args) {
        EventualSafeNodes e = new EventualSafeNodes();
        e.eventualSafeNodes(new int[][]{{1}, {0, 2}, {}});
    }

}
