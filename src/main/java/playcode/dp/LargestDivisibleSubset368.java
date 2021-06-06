package playcode.dp;

import java.util.*;

public class LargestDivisibleSubset368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int dp[] = new int[size];
        Integer[] track = new Integer[size];
        dp[0] = 1;
        int max = 0;
        int pos = 0;
        for (int i = 1; i < size; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        track[i] = j;

                    }
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                pos = i;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[pos]);

        while (track[pos] != null) {
            pos = track[pos];
            stack.push(nums[pos]);
        }
        return new ArrayList<>(stack);
    }
}
