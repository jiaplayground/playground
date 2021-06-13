package playcode.dp;

public class OnesAndZeroes474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int c0 = 0;
            int c1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') c1++;
                else c0++;
            }
            int[][] tmp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                // pay attention: the copy length is N+1
                System.arraycopy(dp[i], 0, tmp[i], 0, n + 1);
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == c0 && j == c1) {
                        dp[i][j] = Math.max(dp[i][j], 1);
                    }
                    if (i >= c0 && j >= c1 && tmp[i - c0][j - c1] > 0) {
                        dp[i][j] = Math.max(dp[i][j], tmp[i - c0][j - c1] + 1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
