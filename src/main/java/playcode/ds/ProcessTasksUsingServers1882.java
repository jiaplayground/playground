package playcode.ds;

import java.util.*;

public class ProcessTasksUsingServers1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int sSize = servers.length;
        int tSize = tasks.length;
        //0: server index, 1: time 2: server weight
        Queue<int[]> freeQueue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        Queue<int[]> runningQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ?
                (a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]) : a[1] - b[1]);

        for (int i = 0; i < sSize; i++) {
            freeQueue.offer(new int[]{i, 0, servers[i]});
        }

        int[] result = new int[tSize];
        for (int t = 0; t < tSize; t++) {
            while (!runningQueue.isEmpty() && runningQueue.peek()[1] <= t) {
                freeQueue.offer(runningQueue.poll());
            }
            int[] curr = null;
            if (!freeQueue.isEmpty()) {
                curr = freeQueue.poll();
                result[t] = curr[0];
                runningQueue.offer(new int[]{curr[0], t + tasks[t], curr[2]});
                continue;
            }
            curr = runningQueue.poll();
            result[t] = curr[0];
            runningQueue.offer(new int[]{curr[0], curr[1] + tasks[t], curr[2]});
        }
        return result;
    }
}
