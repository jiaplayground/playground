package playcode.twoandthreepath;
import java.util.*;
public class TwoSumLessthanequaltarget {
    /**
     Input: nums = [2, 7, 11, 15], target = 24.
     Output: 5.
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        int size = nums.length;
        int left =0;
        int right = size-1;
        int count =0;
        Arrays.sort(nums);
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum<=target){
                count+=right-left;
            }
            if(sum>target){
                right--;
            }
            else left++;

        }
        return count;

    }
}
