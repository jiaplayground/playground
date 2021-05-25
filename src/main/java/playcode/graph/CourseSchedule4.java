package playcode.graph;

import java.util.*;

public class CourseSchedule4 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer>[] map = new Set[numCourses];
        int[] inDegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegrees[edge[0]]++;
            graph.computeIfAbsent(edge[1], p -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            map[i] = new HashSet<Integer>();
            map[i].add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int from = q.poll();
            if (graph.get(from) != null) {
                for (int to : graph.get(from)) {
                    inDegrees[to]--;
                    if (inDegrees[to] == 0) {
                        q.offer(to);
                    }
                    map[to].addAll(map[from]);

                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] qy : queries) {
            if (!map[qy[0]].contains(qy[1])) result.add(false);
            else result.add(true);
        }
        return result;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int i=1;i<s.length(); i++){
            if(s.charAt(i)=='1'){
                continue;
            }
            Integer min = set.ceiling(i-minJump);
            if(min ==null) continue;
            if(min>=i-maxJump){
                set.add(i);
            }
        }
        return (set.contains(s.length()-1));
    }
}
