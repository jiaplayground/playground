package playcode.dp;

/**
 * for
 * 0 1 2 3 4 5 6
 * a b b a x x a
 * dp[0][6] c0 == c6, they can print in one time
 *          c0 == c3, theny can print in one time
 *          they divide the dp[0][6] two parts by the same char in 1:6 as the char c0;
 *          dp[0][6] = the min of dp[0][2] + dp[4][6]
 *                      or dp[0][5]
 *
 */

public class StrangePrinter664 {

    public int strangePrinter(String s) {
        s = "$" + s;
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = 1; i < size; i++) {
            dp[i][i] = 1;
        }

        //if not sure the correctness of the index.
        // walk through the code with a example such as $aa
        for (int len = 2; len < size; len++) {
            for (int i = 1; i < size - len; i++) {
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k <= j; j++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + (k + 1 > j ? 0 : dp[k + 1][j]));
                    }
                }
            }
        }
        return dp[1][size - 1];
    }
}
