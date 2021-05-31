package playcode.backtrackrecursiveplusmemory;

import org.junit.jupiter.api.Test;

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

    private static final int MAX_PICK = 3;

    public String stoneGameIII(int[] stoneValue) {

        int size = stoneValue.length;
        Integer[] memo = new Integer[size + 1];
        int[] sufSum = new int[size + 1];
        int total = 0;
        for (int i = size - 1; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + stoneValue[i];
            total += stoneValue[i];
        }
        int AliceMax = getMaxStone(0, stoneValue, memo, sufSum);
        if (AliceMax * 2 == total) return "Tie";
        if (AliceMax > total - AliceMax) return "Alice";
        return "Bob";

    }

    int getMaxStone(int from, int[] stoneValue, Integer[] memo, int[] sufSum) {
        int size = stoneValue.length;
        if (from >= size) {
            return 0;
        }
        if (memo[from] != null) return memo[from];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = from; i < Math.min(size, from + MAX_PICK); i++) {
            sum += stoneValue[i];
            max = Math.max(max, sum + sufSum[i + 1] - getMaxStone(i + 1, stoneValue, memo, sufSum));
        }
        memo[from] = max;
        return max;
    }

    @Test
    void te() {
        StoneGameII1140 sg = new StoneGameII1140();
        sg.stoneGameIII(new int[]{1, 2, 3, 7});
    }

}
