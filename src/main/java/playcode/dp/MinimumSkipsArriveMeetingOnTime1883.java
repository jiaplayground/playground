package playcode.dp;

import org.junit.jupiter.api.Test;

public class MinimumSkipsArriveMeetingOnTime1883 {
    private static final double EMS = 0.00000001;

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int size = dist.length;
        int[] tmp = new int[dist.length + 1];
        System.arraycopy(dist, 0, tmp, 1, size);
        dist = tmp;
        size++;
        Double[][] dp = new Double[size][size];
        dp[0][0] = 0.000;
        double sum = 0.00;
        for (int i = 1; i < size - 1; i++) {
            sum += Math.ceil(1.0 * dist[i] / speed - EMS);

            dp[i][0] = sum;
            // System.out.println(i+ " time : "  + dp[i][0]);
        }
        dp[size - 1][0] = sum + 1.0 * dist[size - 1] / speed;
        // System.out.println("time : "  + dp[size-1][0]);
        if (dp[size - 1][0] <= hoursBefore) return 0;

        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j <= i; j++) {
                //System.out.println("i: " + i + " j: " + j);
                dp[i][j] = dp[i - 1][j - 1] + 1.00 * dist[i] / speed;//skip at i
                dp[i][j] = Math.min(dp[i][j],
                        Math.ceil((dp[i - 1][j] == null ? 1e10 * 1.00 : dp[i - 1][j])
                                + 1.00 * dist[i] / speed - EMS));
            }
            // the last one we do not skip;
        }
        for (int j = 1; j < size - 1; j++) {
            double time = dp[size - 2][j] + dist[size - 1] * 1.00 / speed;
            if (time <= hoursBefore * 1.00) {
                return j;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        MinimumSkipsArriveMeetingOnTime1883 m = new MinimumSkipsArriveMeetingOnTime1883();
        m.minSkips(new int[]{7, 3, 5, 5}, 2, 10);
    }
}
