package playcode.twopointers;

import java.util.*;

public class ValidTriangleNumber611 {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int count = 0;
        for (int i = size - 1; i > 1; i--) {
            int left = 0;
            int right = i - 1;
            int c = nums[i];
            while (left < right) {
                if (nums[left] + nums[right] <= c) {
                    left++;
                } else {
                    count += (right - left);
                    right--;
                }
            }
        }
        return count;
    }
}
