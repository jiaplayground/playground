package playcode.mix;

import java.util.*;

public class NumberWaysSplitString1573 {

    private static final long  MOD = 1_000_000_007;

    public int numWays(String s) {
        int total = 0;
        int size = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                total++;
                map.put(total, i);
            }
        }
        if (total % 3 != 0) {
            return 0;
        }
        if (total == 0) {
            return (int)((size - 1L) * (size - 2L) / 2 % MOD);
        }
        long left = map.get(total / 3 + 1) - map.get(total / 3);
        long right = map.get(total / 3 * 2 + 1) - map.get(total / 3 * 2);
        return (int )(left * right % MOD);
    }




}


