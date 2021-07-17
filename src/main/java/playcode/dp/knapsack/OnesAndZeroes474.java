package playcode.dp.knapsack;

public class OnesAndZeroes474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // at most m 0's and n 1's in the
        int size = strs.length;
        int[][] count = new int[size + 1][2];
        convert(count, strs);
        int[][][] dp = new int[m + 1][n + 1][size + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 1; k <= size; k++) {
                    if (i == 0 && j == 0) continue;
                    dp[i][j][k] = dp[i][j][k - 1];
                    if (i >= count[k][0] && j >= count[k][1]) {//include k
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - count[k][0]][j - count[k][1]][k - 1] + 1);
                    }
                }
            }
        }
        return dp[m][n][size];
    }

    private void convert(int[][] count, String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            int ones = 0;
            int zeros = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }
            count[i + 1] = new int[]{zeros, ones};
        }
    }



}
