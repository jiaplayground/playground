package playcode.binaysearch.classicsearch;

public class FindPeakElement162 {
    /**
     * i) use left < right template;
     * The exit condition is left == right, then left or right is the answer;
     *  2)prepare for the nums[mid]>nums[mid+1]
     *  So need to exclude the mid+1 beyond the scope by
     *  checking :       if(nums[size-1]>nums[size-2]){
     *             return size-1;
     *         }
     *
     *
     *
     */
    public int findPeakElement(int[] nums) {
        int size = nums.length;
        if(size==1) return 0;
        int left =0;
        int right =size-1;

        if(nums[size-1]>nums[size-2]){
            return size-1;
        }
        while(left < right){
            int mid = left + (right-left)/2;

            if(nums[mid]>nums[mid+1]){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
}
