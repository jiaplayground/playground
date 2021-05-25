package playcode.backtrackrecursiveplusmemory;

import org.junit.jupiter.api.Test;

public class StoneGame {
//this one does not work, why
    public boolean stoneGame2(int[] piles) {
        int size = piles.length;
        Boolean[][] memo = new Boolean[size + 1][size + 1];
        return  canWin(0, size-1, piles, 0, memo);

    }

    private boolean canWin(int left, int right, int[] piles, int result, Boolean[][] memo) {
        if(left>right) return result>0;
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        boolean isWon = true;
        if ((right - left) % 2 == 1) {
            isWon = canWin(left + 1, right, piles, result + piles[left], memo) ||
                    canWin(left, right - 1, piles, result + piles[right], memo);
        } else {

            isWon = canWin(left + 1, right, piles, result - piles[left], memo)
                    && canWin(left, right - 1, piles, result - piles[right], memo);
        }
        memo[left][right] = isWon;
        return isWon;
    }







    @Test
    public void te() {
        StoneGame sg = new StoneGame();
        //sg.stoneGame(new int[]{7,8,8,10});
        boolean x =sg.stoneGame2(new int[]{3,7,2,3});

    }

    public boolean stoneGame1(int[] piles) {
        int N = piles.length;
        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
            }

        return dp[1][N] > 0;
    }
}
