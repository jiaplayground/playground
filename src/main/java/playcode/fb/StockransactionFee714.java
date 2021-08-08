package playcode.fb;

public class StockransactionFee714 {
    //today's state only related to yesterday.

    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int [] sell = new int[prices.length];
        buy[0] = -prices[0];
        for(int i=1; i<prices.length; i++){
            buy[i] = Math.max(sell[i-1] - prices[i], buy[i-1]);
            sell[i] = Math.max( buy[i-1] + prices[i] -fee, sell[i-1]);
        }
        return sell[prices.length-1];
    }

    // exceed time limit
    public int maxProfit_V1(int[] prices, int fee) {

        int size = prices.length;
        int[] dp = new int[size];
        for(int i=1; i<size; i++){
            dp[i] = dp[i-1];
            for(int j=i-1; j>=0; j--){
                int thisProfit = prices[i]-prices[j]-fee;
                if(thisProfit>0){
                    dp[i] = Math.max(dp[i],
                            (j==0 ? 0 : dp[j-1]) + thisProfit
                    );
                }
            }
        }
        return dp[size-1];
    }
}
