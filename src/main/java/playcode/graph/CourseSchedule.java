package playcode.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseSchedule {

    private static final int FIRST_VISITED = 1;
    private static final int NOT_IN_CYCLE = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            graph.computeIfAbsent(edge[1], p -> new ArrayList<>()).add(edge[0]);
        }
        int[] states = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (graph.containsKey(i)) {
                if (inCycle(i, states, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean inCycle(int from, int[] states, Map<Integer, List<Integer>> graph) {
        if (states[from] == NOT_IN_CYCLE) return false;
        if (states[from] == FIRST_VISITED) return true;
        states[from] = FIRST_VISITED;
        for (int to : graph.getOrDefault(from, new ArrayList<>())) {
            if (states[to] == NOT_IN_CYCLE) continue; // comment out this, still work
            if (inCycle(to, states, graph)) {
                return true;
            }
        }
        states[from] = NOT_IN_CYCLE;

        return false;
    }

    @Test
    void test1() {
        CourseSchedule cs = new CourseSchedule();
        cs.canFinish(5, new int[][]{
                {1, 4}, {2, 4}, {3, 1}, {3, 2}
                //{1, 4}, {4, 2}, {3, 1}, {2, 3}
                // {1, 2}, {2, 1}
        });
    }

}
