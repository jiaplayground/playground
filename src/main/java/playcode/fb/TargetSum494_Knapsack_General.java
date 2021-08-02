package playcode.fb;

public class TargetSum494_Knapsack_General {
    //[1,1,1]   target =3

    /**
     * two loop; out loop item; inner loop volume
     * dp[item][volume] dp[i][t] = dp[i-1][t-nums[i]] + dp[i-1][t+nums[i]];
     * as it always is induced from i-1, so we can just use one dimension array
     *
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int num : nums){
            sum += num;
        }//sum =3
        if(target>sum|| target < -sum){
            return 0;
        }
        int[] dp = new int[2*sum+1]; //dp[7]
        dp[sum] =1;// dp[3] =1
        int size = nums.length;//
        for(int i = 0; i < size; i++){
            int[] next = new int[2*sum+1];
            for(int t = 0; t <= 2*sum; t++ ){
                if(t-nums[i]>=0){
                    next[t-nums[i]] += dp[t]; //next[3-1] =1
                }
                if(t+nums[i]<=2*sum){
                    next[t+nums[i]] += dp[t]; //next [3+1] =1
                }
            }
            dp = next;
        }
        return dp[sum+target];

    }






    public int findTargetSumWays_My(int[] nums, int target) {
        return dfs(0, target, nums);
    }

    int dfs(int start, int target, int[] nums) {
        if (start == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        return dfs(start + 1, target + nums[start], nums) +
                dfs(start + 1, target - nums[start], nums);

    }


}
