package playcode.dp.knapsack;

public class CoinChange1And2 {


    // use 1-d array
    //the order of two for loop: out loop
    public int changeHowManyWays(int amount, int[] coins) {
        int[]dp = new int[amount+1];
        dp[0] =1;
        for(int c =0; c<coins.length; c++){
            int[] copy = new int[amount+1];
            System.arraycopy(dp, 0, copy, 0, amount+1);
            for(int a =1;a<=amount; a++ ){
                if(a>=coins[c]){
                    dp[a] = copy[a] // last round without coins[c]
                            + dp[a-coins[c]]; // with one or more coins[c]
                }
            }
        }
        return dp[amount];
    }

    //2-d array
    public int changeHowManyWays2(int amount, int[] coins) {
        int size = coins.length;
        int[][]dp = new int[amount+1][size+1];
        dp[0][0] =1;
        for(int c =1; c<=size; c++){
            //int[] copy = new int[amount+1];
            //System.arraycopy(dp, 0, copy, 0, amount+1);
            for(int a =1;a<=amount; a++ ){
                if(a>=c){

                }
            }
        }
        return 0;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        int dp[] = new int[amount+1];
        for(int i=0; i<= amount; i++) dp[i] = Integer.MAX_VALUE;
        for(int i=1;i<= amount; i++){
            for(int c=0; c<coins.length; c++){
                if(i== coins[c]){
                    dp[i] = 1;
                    continue;
                }
                if(i>coins[c] && dp[i-coins[c]]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[c]] +1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}
