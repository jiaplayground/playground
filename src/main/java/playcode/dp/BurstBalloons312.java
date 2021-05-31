package playcode.dp;

public class BurstBalloons312 {

    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size + 1][size + 1];

        for (int len = 0; len < size; len++) {
            for (int i = 0; i < size - len; i++) {
                int j = i + len;
                for (int k = i; k <= j; k++) {

                    dp[i][j] = Math.max(dp[i][j],
                            (k == 0 ? 0 : dp[i][k - 1]) + dp[k + 1][j]
                                    + (i == 0 ? 1 : nums[i - 1])
                                    * (j + 1 >= size ? 1 : nums[j + 1])
                                    * nums[k]);
                }
            }
        }
        return dp[0][size - 1];
    }


}
