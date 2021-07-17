package playcode.prefix;

import java.util.*;

public class CountVowelsPermutation {

    /**
     * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
     * Each vowel 'a' may only be followed by an 'e'.
     * Each vowel 'e' may only be followed by an 'a' or an 'i'.
     * Each vowel 'i' may not be followed by another 'i'.
     * Each vowel 'o' may only be followed by an 'i' or a 'u'.
     * Each vowel 'u' may only be followed by an 'a'.
     */
//essentially, it is a tree.
    //key point: include current char, how many count.
    public int countVowelPermutation(int n) {
        Map<Character, Integer> map = Map.of(
                'a', 0,
                'e', 1,
                'i', 2,
                'o', 3,
                'u', 4
        );
        Map<Integer, List<Integer>> toMap = Map.of(0, List.of(1),
                1, List.of(0, 2),
                2, List.of(0, 1, 3, 4),
                3, List.of(2, 4),
                4, List.of(0));


        int[] pre = new int[]{1, 1, 1, 1, 1};
        int MOD = 1_000_000_007;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[5];
            for (int from = 0; from < 5; from++) {
                for (int to : toMap.get(from)) {
                    curr[to] = (curr[to] + pre[from]) % MOD;
                }
            }
            pre = curr;
        }

        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + pre[i]) % MOD;
        }
        return result;
    }


}


