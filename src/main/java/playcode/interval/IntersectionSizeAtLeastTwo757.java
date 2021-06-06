package playcode.interval;

import java.util.Arrays;

public class IntersectionSizeAtLeastTwo757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int right = intervals[0][1];
        int left = right - 1;
        int count = 2;
        //[[1,3],[3,7],[5,7],[7,8]]
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // skip if curr[1] == right
            if (curr[0] > right) { // disjoin
                right = curr[1];
                left = right - 1;
                count += 2;
                continue;
            }

            if (curr[0] == right) {
                left = right;
                right = curr[1];
                count++;
            }

            if (left < curr[0]) { // curr[0]<right //right point included
                left = right;
                right = curr[1];
                count++;
            }
        }
        return count;
    }
}
