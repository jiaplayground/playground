package playcode.dd;

import java.util.*;
public class MaximumPerformanceTeam1383 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //10:44
        long max =0;
        int[][] perf = new int[n][2];
        for(int i=0; i<n; i++){
            perf[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(perf, (a,b)->a[1]==b[1]? b[0]-a[0] : b[1]-a[1]);
        long speedSum =0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            if(i<k){
                speedSum +=perf[i][0];
                pq.offer(perf[i][0]);
            }
            else{
                if(pq.peek()<perf[i][0]) {
                    pq.offer(perf[i][0]);
                    speedSum += (perf[i][0] - pq.poll());
                }
            }
            max = Math.max(max, 1L*speedSum * perf[i][1]);
        }

        return (int)(max % (long)(1e9+7));
    }
}
