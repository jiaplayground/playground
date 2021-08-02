package playcode.fb;

public class SortColors75 {
    public void sortColors(int[] nums) {
        // left point, right point, middle point
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int mid = 0;
        //test case 1,2,0,1 // test case : 2,2,1,1
        //case 3: [2,0,2,1,1,0]
        //for case 3: left =0; right =5, mid=0// swap: 0,0,2,1,1,2
        //left =2, right=4, mid =1
        // left =2, right=4, mid =2 swap => 0 0 1,1,2,2
        while (left < right && mid < size && mid <= right) {
            if (nums[left] == 0) {
                left++;
                continue;
            } else if (nums[right] == 2) {
                right--;
                continue;
            }
            if (mid < left) {
                mid = left;
            }
            //mid =1 //swap =>1, 1, 0,2
            //left 0, right 2, mid =1;
            //left 0, right 2, mid 2  1,1,0,2 // swap => 0,1,1,2
            //left 1, right = 0,1,1,2
            if (nums[mid] == 0) {
                swap(left, mid, nums);
                continue;
            } else if (nums[mid] == 2) {
                swap(right, mid, nums);
                continue;
            }
            mid++;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
