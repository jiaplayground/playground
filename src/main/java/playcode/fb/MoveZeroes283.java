package playcode.fb;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        //1 0,1 0,0 3 0,12 =>
        int size =nums.length;
        int left =0; int right =0;
        int zeros =0;
        for(int n : nums){
            if(n==0){
                zeros++;
            }
        }
        if(zeros==0) return;
        while(nums[left]!=0){
            left++;
        }
        right = left+1;
        //1 0 0 1 1// left = 1, right =2
        // left=1, right =3
        //1 1 0 1 1 //left = 2, right =4
        //left =3 right =5 // 1 1 1 1 1

        while(right<size){
            if(nums[right]==0){
                right++; continue;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        //fill the zeros;
        //size =4, zero =1; 4-1=3 1 2  0
        for(int i= size-zeros; i<size; i++){
            nums[i] = 0;
        }
    }
}
