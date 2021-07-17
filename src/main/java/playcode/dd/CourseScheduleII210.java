package playcode.dd;

import java.util.*;

public class CourseScheduleII210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] preq : prerequisites) {
            int from = preq[1];
            int to = preq[0];
            graph.computeIfAbsent(from, e -> new ArrayList<>()).add(to);
            indegrees[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int from = q.poll();
            result.add(from);
            for (int to : graph.getOrDefault(from, new ArrayList<>())) {
                indegrees[to]--;
                if (indegrees[to] == 0) {
                    q.offer(to);
                }
            }
        }
        if (result.size() != numCourses) {
            return new int[]{};
        }
        int[] out = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            out[i] = result.get(i);
        }
        return out;
    }
}
