package playcode.prefix;

import java.util.*;

public class ContiguousArray525 {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] == 0 ? -1 : 1;
            sum += curr;
            if (preSum.containsKey(sum)) {
                max = Math.max(max, i - preSum.get(sum));
            } else {
                preSum.put(sum, i);
            }
        }
        return max;
    }

    /**
     * Greedy not work
     * [0,0,1,0,0,0,1,1]
     */
    public int findMaxLength1(int[] nums) {

        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (stack.isEmpty()) {
                stack.push(new int[]{num, i});
                continue;
            }
            if (stack.peek()[0] + num == 1) {
                int[] top = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? i + 1 : i - stack.peek()[1]));
            } else {
                stack.push(new int[]{num, i});
            }
        }
        return max;
    }
}
