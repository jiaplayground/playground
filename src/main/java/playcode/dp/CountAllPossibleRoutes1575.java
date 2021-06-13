package playcode.dp;

public class CountAllPossibleRoutes1575 {
    private static final int MOD = 1_000_000_007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int size = locations.length;
        int[][] dp = new int[fuel + 1][size];
        dp[fuel][start] = 1;

        for (int f = fuel; f > 0; f--) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j) continue;
                    int cost = Math.abs(locations[i] - locations[j]);
                    if (f < cost) continue;
                    dp[f - cost][j] = (dp[f - cost][j] + dp[f][i]) % MOD;
                }
            }

        }
        int result = 0;
        for (int i = 0; i <= fuel; i++) {
            result = (dp[i][finish] + result) % MOD;
        }
        return result;
    }
}
