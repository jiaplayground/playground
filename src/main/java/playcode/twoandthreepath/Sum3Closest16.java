package playcode.twoandthreepath;

import java.util.Arrays;

public class Sum3Closest16 {
    public int threeSumClosest(int[] nums, int target) {
        // -1,1,2,4
        int size = nums.length;
        Arrays.sort(nums);
        int min = 1_000_000;
        for (int i = 0; i < size - 1; i++) {
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (Math.abs(min - target) > Math.abs(sum - target)) {
                    min = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return min;
    }
}
