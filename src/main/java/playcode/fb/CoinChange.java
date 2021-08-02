package playcode.fb;

public class CoinChange {

    public int change_V0(int amount, int[] coins) {

        int size = coins.length;
        int[][] dp = new int[size + 1][amount + 1];
        for (int i = 0; i <= size; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= size; i++) {
            for (int a = 1; a <= amount; a++) {
                int coin = coins[i - 1];
                dp[i][a] = dp[i - 1][a];

                if (a >= coin) {
                    dp[i][a] += dp[i][a - coin];
                }
            }
        }
        return dp[size][amount];
    }

    public int changeV1(int amount, int[] coins) {
/**
 * Input: amount = 5, coins = [1,2,5]
 * dp[0] =1;
 * c=0; coint =1  dp0=1 dp[1]= 1, dp[2] = dp[2-1] =1;         dp[3] =1;           dp[4] =1;               dp[5] =1;
 * c=1 coin =2:                   dp[2]= dp[2] + dp[2-2]=3    dp[3]= dp[3] + dp[3-2]=3
 *
 */
        int size = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c = 0; c < size; c++) {
            for (int a = 1; a <= amount; a++) {
                if (a >= coins[c]) {
                    dp[a] += dp[a - coins[c]];
                }
            }
        }
        return dp[amount];
    }


    public int change_V2(int amount, int[] coins) {
        int size = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c = 0; c < size; c++) {
            int[] next = new int[amount + 1];
            for (int a = 0; a <= amount; a++) {
                next[a] = dp[a]; //not use coin[c]
                if (a >= coins[c]) {
                    next[a] += next[a - coins[c]]; // reuse
                    //wrong if
                    //next[a] +=  next[a-coins[c]] + dp[a-coins[c]]
                }
            }
            dp = next;

        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int size = coins.length;
        int[] dp = new int[amount + 1];
        for (int a = 1; a <= amount; a++) {
            for (int c = 0; c < size; c++) {
                if (a == coins[c]) {
                    dp[a] = 1;
                }
                if (a > coins[c] && dp[a - coins[c]] > 0) {
                    dp[a] = Math.min(dp[a] == 0 ? Integer.MAX_VALUE : dp[a],

                            dp[a - coins[c]] + 1
                    );
                }

            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];

    }
}
