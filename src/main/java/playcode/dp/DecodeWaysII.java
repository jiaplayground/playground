package playcode.dp;

import org.junit.jupiter.api.Test;

public class DecodeWaysII {
    private static final int MOD = 1_000_000_007;

    //"1*0*"
    //1*
    public int numDecodings(String s) {
        /**
         *      12*
         *      dp[i] = dp[i-1]*way(i)   //pos i be a independent number
         *         + dp[i-2]*way(i-1, i)          // way pos i-1 and i to form numbers;
         */
        int size = s.length();
        long res1 = ways(s.charAt(0)); // i-2
        if (size == 1) {
            return (int) res1;
        }
        long res2 = res1 * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));  // i-1
        for (int i = 2; i < size; i++) {
            //i=2 res2 = 18; res1 = 1; || after : res1 = 18, rest2 = 0 + 1*2 =2;
            long tmp = res2;
            res2 = (res2 * ways(s.charAt(i)) + res1 * ways(s.charAt(i - 1), s.charAt(i))) % MOD;
            res1 = tmp;
        }
        return (int) res2;
    }

    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private int ways(char pre, char curr) { //number of ways pre and curr char can form
        //*0

        if (pre == '*' && curr == '*') {
            return 9 + 6;
        }
        if (pre == '*') {
            if (curr > '6') {
                return 1;
            }
            return 2;
        }
        if (curr == '*') {
            if (pre == '1') {
                return 9;
            }
            if (pre == '2') {
                return 6;
            }
            return 0;
        }
        //pre !='*' && curr != '*'
        int num = Integer.parseInt(pre + "" + curr);
        if (num >= 10 && num <= 26) {
            return 1;
        }
        return 0;
    }

    //not work
    public int numDecodings1(String s) {
        s = "$" + s;
        int size = s.length();
        //"7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"
        long[] dp = new long[size];
        dp[0] = 1;
        for (int i = 1; i < size; i++) {
            char c = s.charAt(i);
            //"1*"
            if (c == '*') {
                dp[i] = (dp[i - 1] * 9) % MOD;
                if (s.charAt(i - 1) == '1') {
                    dp[i] = (dp[i] + (i > 1 ? dp[i - 2] * 9 : 9)) % MOD;
                } else if (s.charAt(i - 1) == '2') {
                    dp[i] = (dp[i] + (i > 1 ? dp[i - 2] * 6 : 6)) % MOD;
                } else if (s.charAt(i - 1) == '*') {
                    dp[i] = (dp[i] + (i > 1 ? dp[i - 2] * 9 : 9) + (i > 1 ? dp[i - 2] * 6 : 6)) % MOD;
                }
            }
            if (c == '0') { // 10// 1*0 dp[0]=[1-9] dp[1] = dp[0] // 10, 20
                if (i == 1 || s.charAt(i - 1) == '0' || (s.charAt(i - 1) > '2' && s.charAt(i - 1) <= '9')) {
                    return 0;
                }
                if (s.charAt(i - 1) == '*') {
                    //*0 // dp[0] =9 // dp[1] = dp[0]
                    dp[i] = (dp[i - 2] * 2) % MOD;
                    continue;
                }
                //120
                dp[i] = dp[i - 2];
            }
            //101
            if (c >= '1' && c <= '6') {
                dp[i] = 1;
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2];
                    continue;
                }
                //121 111
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                    continue;
                }
                //*1 dp[0] =9
                if (s.charAt(i - 1) == '*') {
                    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
                    continue;
                }
                if (s.charAt(i - 1) >= '3' && s.charAt(i - 1) <= '9') {
                    dp[i] = dp[i - 1];
                }
            }
            if (c >= '7' && c <= '9') {//106
                dp[i] = 1;
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2];
                    continue;
                }
                //121 111
                if (s.charAt(i - 1) == '1') {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                    continue;
                }
                //*1 dp[0] =9
                if (s.charAt(i - 1) == '*') {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                    continue;
                }
                if (s.charAt(i - 1) >= '2' && s.charAt(i - 1) <= '9') {
                    dp[i] = dp[i - 1];
                }

            }
        }
        return (int) dp[size - 1];
    }

    @Test
    void p() {
        DecodeWaysII t = new DecodeWaysII();
        t.numDecodings("0");
    }
}
