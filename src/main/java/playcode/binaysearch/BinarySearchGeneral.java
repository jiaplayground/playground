package playcode.binaysearch;

/**
 * 35. Search Insert Position
 * 278. First Bad Version
 */
//https://www.youtube.com/watch?v=U3U9XMtSxQc
public class BinarySearchGeneral {

    //Two template

    /**
     * 1) terminal condition: left == right
     * 2)
     *
     *
     * [5, 10] search 1;
     * terminate in left = right = 0
     * left =0; right =2 mid = 1 => left =0; right =1 mid =0 => left =0; right =0; || terminate
     *
     *  * [5, 10] search 15;
     * terminate in right = size
     * : left =0, right =2, mid =1 => left =2, right =2; terminate
     *
     * [5, 10] search 7;
     * left =0; right = 2, mid = 1 => left =0; right = 1, mid =0; => left =0, right =0, terminate
     *
     */
    public int search_T1(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid;
            }
            else {
                left = mid+1; //make sure the left can move to right most (index of last element +1)
            }
        }
        return -1;

    }

    /**
     *
     * 1) terminal condition left > right
     * 2)
     *
     *
     */

    public int searchInsert_T2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsertV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
