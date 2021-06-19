package playcode.dp;

import java.util.Comparator;

public class LargestIntegerWithDigits1449 {
// this is a knapsack problem and the item is allow to use repeatedly.
    // compare to the knapsack problem.
    // the for loop order is first volume, then item
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        for (int i = 0; i <= target; i++) dp[i] = "";
        for (int t = 1; t <= target; t++) {
            for (int i = 1; i <= cost.length; i++) {
                int take = cost[i - 1];
                if (t < take) continue;
                if (t == take) {
                    dp[t] = getMax(dp[t], "" + i);
                    continue;
                }
                if (!dp[t - take].isEmpty()) {
                    dp[t] = getMax(dp[t], dp[t - take] + i);
                }
            }
        }
        return dp[target].isEmpty()? "0" : dp[target];
    }

    String getMax(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? s1 : s2;
        }
        return s1.compareTo(s2) < 0 ? s2 : s1;
    }

    // not needed
    Comparator<String> cmp = (s1, s2) -> {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        return s1.compareTo(s2);
    };
}
