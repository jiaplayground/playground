package playcode.dp;

import java.util.*;

public class MinimumCostTickets983 {

    private static final int[] INTERVALS = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {

        //For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
        int size = days.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < costs.length; j++) {
                Integer last = map.floorKey(days[i] - INTERVALS[j]);
                map.put(days[i], Math.min(map.getOrDefault(days[i], Integer.MAX_VALUE),
                        (last == null ? 0 : map.get(last)) + costs[j]
                ));

            }

        }
        return map.get(days[size - 1]);
    }

}
