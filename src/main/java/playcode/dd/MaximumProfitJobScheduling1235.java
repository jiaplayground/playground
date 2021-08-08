package playcode.dd;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumProfitJobScheduling1235 {
    //7:14
    static class ProfitByTime {
        int end;
        int start;
        int profit;
        public ProfitByTime(int start, int end, int profit ){
            this.start =start;
            this.end = end;
            this.profit = profit;
        }
    }
    //[1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
   // [1,3,50] [2, 4, 10], [3,5, 40], [3, 6, 70]
    //[3,50, 4 50, 90, 6 120 ]

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxEndTime =0;
        Queue<ProfitByTime> minHeap = new PriorityQueue<>((a, b)-> a.end -b.end);
        for(int i=0 ;i<profit.length; i++){
            minHeap.offer(new ProfitByTime(startTime[i], endTime[i], profit[i]));
            maxEndTime = Math.max(maxEndTime, endTime[i]);
        }
        TreeMap<Integer, Integer> profitsAtTime = new TreeMap<>();
        int max =0;
        while(!minHeap.isEmpty()){
            ProfitByTime top = minHeap.poll();
            Integer lastProfitTime =  profitsAtTime.floorKey(top.start);
            System.out.println(lastProfitTime);
            max =  Math.max((lastProfitTime==null ? 0 : profitsAtTime.get(lastProfitTime)) + top.profit, max);
            profitsAtTime.put(top.end, max);
        }
        return max;
    }
    @Test

    void test() {
        MaximumProfitJobScheduling1235 m = new MaximumProfitJobScheduling1235();
        m.jobScheduling(new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70}
        );
    }

}
