package playcode.backtrackrecursiveplusmemory;

public class GuessNumberHigherLowerII375 {
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return getMinAmount(1, n, memo);
    }

    private int getMinAmount(int from, int to, int[][] memo) {
        if (from >= to) return 0;
        if (memo[from][to] > 0) return memo[from][to];
        int min = Integer.MAX_VALUE;
        for (int i = from; i <= to; i++) {
            min = Math.min(min, i + Math.max(getMinAmount(from, i - 1, memo), getMinAmount(i + 1, to, memo)));
        }
        memo[from][to] = min;
        return min;
    }
}
