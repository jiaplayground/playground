package playcode.dp;

public class LongestPalindromicSubsequence516 {

    public int longestPalindromeSubseq(String s) {
        int size = s.length();
        int[][] dp = new int[size + 1][size + 1];

        for (int len = 0; len < size; len++) {
            for (int i = 0; i < size - len; i++) {
                int j = i + len;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }
}
