package playcode.dp.knapsack;

public class CoinChange1And2 {
    //base case m[i][0] =0 (i from 0 to  total money)
//  m[0][j] =1( j #of coins )
//transation: m[t][k] = f(t-d[k], k) + f(t, k-1). here f(t-d[k], k) represents choosing k-th coins, and f(t, k-1) represents choosing (k-1)th coins
    // this is very close the knapsack problem

    // value =   m[w][item]
    // max Value =  max(m[w-WeightOfItemI][itemI] + valueOfI, m[w][itemI-1]        );

    public int change(int amount, int[] coins) {

        int size = coins.length;
        int[][] dp = new int[size+1][amount+1];
        for(int i=0; i<=size; i++){
            dp[i][0] =1;
        }
        for(int i=1;i<=size; i++){
            for(int a=1; a<=amount; a++){
                int coin = coins[i-1];
                dp[i][a]=dp[i-1][a];

                if(a>=coin){
                    dp[i][a] +=dp[i][a-coin];
                }
            }
        }
        return dp[size][amount];
    }
    /*
    just use one dimension
    basic idea is to first work on the all combination only one kind of coin, then two kind of coins, and so on so forth

    for instance : coins [1, 2, 5] and amount 10;
    just use coins[0], m[0] to m[10] all have one way;
    when loop to coins[1], then m[6] equals to  m[6](only use coins[0]) and m[6-2](use coins[0] and coins[1])
      */

    public int change1(int amount, int[] coins) {

        int[] m = new int[amount + 1];

        m[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (i - coins[j] >= 0) {
                    m[i] = m[i] + m[i - coins[j]];
                }

            }
        }

        return m[amount];

    }


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

    public static void main(String[] args){
        CoinChange1And2 x = new CoinChange1And2();
        x.change(10, new int[]{1,2,5});

    }
}
