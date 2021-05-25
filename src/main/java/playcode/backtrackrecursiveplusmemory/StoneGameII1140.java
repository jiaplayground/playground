package playcode.backtrackrecursiveplusmemory;

public class StoneGameII1140 {
    public int stoneGameII(int[] piles) {
        int size = piles.length;
        int[] sufSum = new int[size + 1];
        sufSum[size - 1] = piles[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            sufSum[i] = piles[i] + sufSum[i + 1];
        }
        return getMax(new int[size][size], 0, 1, sufSum, piles);
    }

    // deal with a round, or two player play each once
    int getMax(int[][] memo, int left, int m, int[] sufSum, int[] piles) {
        int size = piles.length;
        if (2 * m >= size - left + 1) {
            return sufSum[left];
        }
        if (memo[left][m] > 0) return memo[left][m];
        int max = 0;
        int sum = 0;
        for (int i = left; i < Math.min(size, left + 2 * m); i++) {
            sum += piles[i];
            max = Math.max(max,
                    sum + sufSum[i + 1] - getMax(memo, i + 1, Math.max(i - left + 1, m), sufSum, piles));
        }
        memo[left][m] = max;
        return max;
    }

}
