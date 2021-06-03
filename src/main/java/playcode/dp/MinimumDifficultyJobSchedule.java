package playcode.dp;

public class MinimumDifficultyJobSchedule {

    //template

    public int minDifficulty(int[] jobDifficulty, int d) {
        int size = jobDifficulty.length;
        if (d > size) return -1;
        Integer[][] dp = new Integer[size][d];
        int peak = 0;
        for (int i = 0; i < size; i++) {
            peak = Math.max(peak, jobDifficulty[i]);
            dp[i][0] = peak;
        }

        for (int i = 1; i < size; i++) {
            for (int k = 1; k <= Math.min(i, d - 1); k++) {
                int max = jobDifficulty[i];
                for (int j = i; j >= k; j--) {
                    max = Math.max(max, jobDifficulty[j]);
                    System.out.println("i" + i + " k:" + k + " j :" + j);
                    dp[i][k] = Math.min(dp[i][k] == null ? Integer.MAX_VALUE : dp[i][k],
                            dp[j - 1][k - 1] +
                                    max);

                }
            }
        }
        return dp[size - 1][d - 1];
    }

}
