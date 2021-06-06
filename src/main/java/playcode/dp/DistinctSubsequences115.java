package playcode.dp;

public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();
        s= "$"+s;
        t = "$" + t;
        //dp[i,j] = i==j dp[i-1][j-1]+dp[i-1][j] // dp[i-1][j]
        int[][]dp = new int[sSize+1][tSize+1];
        for(int i=0; i<=sSize; i++) dp[i][0] =1; // empty case;
        for(int i=1; i<=sSize; i++){
            for(int j=1; j<=tSize; j++){
                dp[i][j] = (s.charAt(i) == t.charAt(j) ? dp[i-1][j-1] :0)
                        + dp[i-1][j];
            }
        }
        return dp[sSize][tSize];
    }

}
