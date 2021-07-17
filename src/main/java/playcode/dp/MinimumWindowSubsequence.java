package playcode.dp;

import org.junit.jupiter.api.Test;

//https://www.lintcode.com/problem/857/
public class MinimumWindowSubsequence {

    public String minWindow(String S, String T) {
        S = "$" + S;
        T = "$" + T;
        char[] charS = S.toCharArray();
        char[] charT = T.toCharArray();
        int sSize = S.length();
        int tSize = T.length();
        Integer[][] dp = new Integer[sSize][tSize];
        dp[0][0] = 0;
        for (int i = 1; i < sSize; i++) {
            if (charT[1] == charS[i]) {
                dp[i][1] = 1;
            }
        }
        for (int t = 1; t < tSize; t++) {
            for (int i = 1; i < sSize; i++) {
                if (charS[i] != charT[t]) {
                    if (dp[i - 1][t] != null) {
                        dp[i][t] = dp[i - 1][t] + 1;
                    }
                } else {
                    if (dp[i - 1][t - 1] != null) {
                            dp[i][t] = dp[i - 1][t - 1] + 1;
                    }
                }
            }
        }
        int end = 0;
        int length = Integer.MAX_VALUE;
        for(int i=1; i<sSize; i++){
            if(dp[i][tSize-1]!=null && dp[i][tSize-1]<length){
                length =  dp[i][tSize-1];
                end = i;
            }
        }
        if(end ==0){
            return "";
        }
        return S.substring(end+1-length, end+1);

    }

    @Test
    void test() {
        MinimumWindowSubsequence x = new MinimumWindowSubsequence();
        x.minWindow("abcdebdde",
                "bde");
    }
}
