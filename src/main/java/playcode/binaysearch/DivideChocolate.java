package playcode.binaysearch;

public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        // write your code here
        int sum = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
        }
        int left = 0;
        int right = sum;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isWorked(mid, sweetness, K + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isWorked(int min, int[] sweetness, int K) {
        int sum = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum >= min) {
                K--;
                if (K == 0) {
                    return true;
                }
                sum = 0;
            }
        }
        return false;
    }

    public int maximizeSweetness2(int[] sweetness, int K) {
        //memory exceeded
        int size = sweetness.length;
        int[][] dp = new int[size][K + 2];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k <= Math.min(K + 1, i + 1); k++) {
                int sum = 0;
                for (int j = i; j >= k; j--) {
                    sum += sweetness[j];
                    dp[i][k] = Math.max(dp[i][k], (k - 1 >= 0 && j - 1 >= 0) ? Math.min(dp[j - 1][k - 1], sum) : sum);
                }
            }
        }
        return dp[size - 1][K];
    }


}
