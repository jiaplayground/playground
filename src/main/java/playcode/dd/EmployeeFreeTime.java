package playcode.dd;

import java.util.*;

public class EmployeeFreeTime {


    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param schedule: a list schedule of employees
     * @return: Return a list of finite intervals
     */
    public List<Interval> employeeFreeTime(int[][] schedule) {
        // Write your code here
        List<int[]> schedules = new ArrayList<>();
        for (int[] one : schedule) {
            for (int i = 0; i < one.length; i = i + 2) {
                schedules.add(new int[]{one[i], one[i + 1]});
            }
        }
        Collections.sort(schedules, (a, b) -> a[0] - b[0]);
        List<Interval> result = new ArrayList<>();

        int[] pre = schedules.get(0);
        for (int i = 1; i < schedules.size(); i++) {
            int[] curr = schedules.get(i);
            if (curr[0] > pre[1]) {
                result.add(new Interval(pre[1], curr[0]));
                pre = curr;
                continue;
            }
            pre[1] = Math.max(pre[1], curr[1]);
        }
        return result;
    }
}
