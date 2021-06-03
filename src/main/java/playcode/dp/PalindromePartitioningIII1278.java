package playcode.dp;

public class PalindromePartitioningIII1278 {
    //Need to speed up; kind of slow
    public int palindromePartition(String s, int k) {
        //dp[i,k] = dp[j-1][k-1] + cost[j:i]
        int size = s.length();
        Integer dp[][] = new Integer[size][k];
        for (int i = 0; i < size; i++) {
            dp[i][0] = cost(s, 0, i);
        }
        for (int i = 1; i < size; i++) {
            for (int m = 1; m <= Math.min(k - 1, i); m++) {
                for (int j = i; j >= m; j--) {
                    dp[i][m] = Math.min(dp[i][m] == null ? Integer.MAX_VALUE : dp[i][m],
                            dp[j - 1][m - 1] + cost(s, j, i));
                }
            }
        }
        return dp[size - 1][k - 1];
    }


    private int cost(String s, int from, int to) {
        int count = 0;
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                count++;
            }
            from++;
            to--;
        }
        return count;
    }
}
