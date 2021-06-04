package playcode.dp;

public class FillingBookcaseShelves1005 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        //  xxxxY dp[i] = min ( dp[j-1] + maxHeigth[j:i])
        //open a new layer from j to i, in the range of the sum Width from j to i <= shelf_width
        int size = books.length;
        int dp[] = new int[size];
        dp[0] = books[0][1];
        for (int i = 1; i < size; i++) {
            int peak = books[i][1];
            int sumWidth = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                peak = Math.max(peak, books[j][1]);
                if (sumWidth + books[j][0] > shelf_width) {
                    break;
                }
                dp[i] = Math.min(dp[i], peak + (j == 0 ? 0 : dp[j - 1]));
                sumWidth += books[j][0];
            }

        }
        return dp[size - 1];

    }
}
