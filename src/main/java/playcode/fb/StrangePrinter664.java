package playcode.fb;

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
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }
        for(int len =2; len <= size; len++){
            for(int start =0; start<=size-len; start++){
                int end = start + len -1;
                dp[start][end] = 1 + dp[start+1][end];

                for(int mid =start+1; mid<=end; mid++){
                    if(s.charAt(start) == s.charAt(mid)){
                        dp[start][end] = Math.min(dp[start][end],
                                //(mid+1>end ? 0  : dp[mid+1][end]) should had () wrap
                                dp[start+1][mid] +  (mid+1>end ? 0  : dp[mid+1][end]));
                    }
                }
            }
        }
        return dp[0][size-1];
    }
}
