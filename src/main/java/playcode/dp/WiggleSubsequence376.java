package playcode.dp;

public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        int max = 1;
        Boolean isUp = null;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if((isUp==null ||isUp) && nums[i]<nums[i-1]){
                isUp = false;;
                max++;
            }
            else if((isUp == null || !isUp) && nums[i]>nums[i-1] ){
                isUp= true;
                max++;
            }
        }
        return max;
    }
}
