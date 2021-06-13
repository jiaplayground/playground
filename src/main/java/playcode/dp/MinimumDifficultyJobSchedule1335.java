package playcode.dp;

public class MinimumDifficultyJobSchedule1335 {

    //template
    public int minDifficulty(int[] jobDifficulty, int d) {
        int size = jobDifficulty.length;
        if (d > size) return -1;
        int[][] dp = new int[size + 1][d + 1];
        int max = jobDifficulty[0];
        for (int i = 0; i < size; i++) {
            max = Math.max(max, jobDifficulty[i]);
            dp[i][0] = max;
        }
        for (int i = 1; i < size; i++) {
            for (int t = 1; t <= Math.min(d - 1, i); t++) {
                //i=3 and t =1
                dp[i][t] = Integer.MAX_VALUE;
                int peak = jobDifficulty[i];
                for (int f = i; f >= t; f--) {
                    peak = Math.max(peak, jobDifficulty[f]);
                    dp[i][t] = Math.min(dp[i][t], dp[f - 1][t - 1] + peak);
                }
            }
        }
        return dp[size - 1][d - 1];
    }

    public int minDifficulty1(int[] jobDifficulty, int d) {
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
