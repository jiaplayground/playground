package playcode.dp;

public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // loop order: always item first, then inner loop for volume
        for (int i = 0; i < size; i++) {
           //the copy to remember the last round(from nums[0:i-1]) dp
            boolean[] copy = new boolean[target + 1];
            //can avoid this copy by backward:
            // for(int t = target; t >=1; t++)
            System.arraycopy(dp, 0, copy, 0, target + 1);
            for (int t = 1; t <= target; t++) {
                if (copy[t] || (t >= nums[i] && copy[t - nums[i]])) {
                    dp[t] = true;
                }
            }
        }
        return dp[target];
    }
}
