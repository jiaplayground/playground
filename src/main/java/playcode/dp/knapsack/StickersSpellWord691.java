package playcode.dp.knapsack;

import org.junit.jupiter.api.Test;

import java.util.*;

public class StickersSpellWord691 {
    public int minStickers(String[] stickers, String target) {
        int size = target.length();
        int N = (1 << (size)) - 1;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int state = 0; state <= N; state++) {
            for (int s = 0; s < stickers.length; s++) {
                if (dp[state] == Integer.MAX_VALUE) continue;//key point
                String st = stickers[s];
                int newState = getState(state, st, target);
                dp[newState] = Math.min(dp[newState], dp[state] + 1);
            }
        }
        return dp[N] == Integer.MAX_VALUE ? -1 : dp[N];
    }

    private int getState(int state, String s, String target) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if ((state & (1 << i)) > 0) {
                continue;
            }
            if (map.get(c) != null && map.get(c) > 0) {
                state = state ^ (1 << i);
                map.put(c, map.get(c) - 1);
            }
        }
        return state;
    }

    @Test
    void test() {
        StickersSpellWord691 t = new StickersSpellWord691();
        t.minStickers(new String[]{"wth", "exa"}, "tahh");
    }


}
