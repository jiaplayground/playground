package playcode.binaysearch.classicsearch;

public class SearchRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        //first consider leftmost and right most parts
        //as those two parts are continuously increasing regions

        int left =0; int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }

            //left part is a continuously increasing region
            if(nums[left] <=nums[mid] ){
                //search space is left part
                if(target< nums[mid] && target>=nums[left]){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            else { //nums[left] >nums[mid]
                //the right part is is a continuously increasing region
                //search space is right
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }

            }
        }
        return -1;
    }

}
