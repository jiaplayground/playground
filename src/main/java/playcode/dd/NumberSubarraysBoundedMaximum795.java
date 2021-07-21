package playcode.dd;

public class NumberSubarraysBoundedMaximum795 {
    //idea like prefix:
    //each time the subarray end with the current element
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int start = 0;
        int meet = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr <= right && curr >= left) {
                meet = i;
            }
            if (curr > right) {
                start = i + 1;
                meet = -1;
            }
            if (start <= i && meet >= 0) {
                count += (meet - start + 1);
            }
        }
        return count;
    }
}
