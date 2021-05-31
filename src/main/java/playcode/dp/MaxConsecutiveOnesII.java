package playcode.dp;

public class MaxConsecutiveOnesII {
    //Given a binary array, find the maximum number of
    // consecutive 1s in this array if you can flip at most one 0.
    public int findMaxConsecutiveOnes(int[] nums) {
        int flipped=0;
        int noFlip=0;
        int max =0;
        for(int i=0;i<nums.length; i++){
            if(nums[i] ==0){
                flipped = noFlip+1;
                noFlip=0;
                continue;
            }
            flipped++;
            noFlip++;

            max = Math.max(max, flipped);
        }
        return max;
    }
}
