package playcode.binaysearch.classicsearch;

public class MinimumInRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int left =0;
        int right = nums.length-1;
        int min =nums[0];
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid]<nums[0]){
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
            else {
                min = Math.min(min, nums[left]);
                left = mid+1;

            }
        }
        return min;
    }
}
