package playcode.fb;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        //[1,2,1]
        int size = nums.length;
        boolean[][] dp = new boolean[sum/2+1][size];
        if(sum%2==1) return false;
        //target
        for(int i=0; i< nums.length; i++){
            for(int t=1; t<= sum/2; t++){
                if(i>0) dp[t][i] = dp[t][i-1];
                if(t==nums[i]){
                    dp[t][i] =true;
                }
                if(!dp[t][i] && t>nums[i] && i>0){
                    dp[t][i] =  dp[t-nums[i]][i-1];
                }
            }
        }

        return dp[sum/2][size-1];
    }
}
