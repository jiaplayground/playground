package playcode.dd;

import java.util.*;

public class MaximumLengthConcatenatedUniqueCharacters1239 {

    public int maxLength(List<String> arr) {
        List<Integer> chars = new ArrayList<>();
        dfs(0, 0, chars);
        return max;

    }

    private void dataNormalize(List<Integer> chars, List<String> arr) {
        for (String s : arr) {
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                int n = s.charAt(i) - 'a';
                if ((num & (1 << n)) > 0) {
                    num = 0;
                    break;
                }
                num ^= 1 << n;
            }
            if (num > 0) {
                chars.add(num);
            }
        }
    }

    private int dfs(int pos, int state, List<Integer> chars) {
        if (pos == chars.size()) {
            return countSetBit(state);
        }
        int max = 0;
        for (int i = pos; i < chars.size(); i++) {
            int curr = chars.get(i);
            if ((curr & state) == 0) {
                max = Math.max(max, dfs(pos + 1, state | curr, chars));
            }
        }
        return max;
    }

    private int countSetBit(int state) {
        int count = 0;
        while (state > 0) {
            if ((state & 1) > 0) {
                count++;
            }
            state = state / 2;
        }
        return count;
    }


    /**
     * Normal DFS. worked. faster than 90.60%
     */
    int max = 0;
    public int maxLength_V1(List<String> arr) {
        helper(0, arr,  new boolean[26]);
        return max;

    }

    private void helper(int pos, List<String> arr,  boolean[] uniq) {
        if (pos == arr.size()) {
            return;
        }
        for (int i = pos; i < arr.size(); i++) {
            boolean[] merged = merge(uniq, arr.get(i));
            if (merged != null) {
                helper(i + 1, arr,  merged);
            }
        }
    }
    private boolean[] merge(boolean[] uniq, String s) {
        boolean[] merged = new boolean[26];
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (uniq[i]) {
                merged[i] = uniq[i];
                count++;
            }
        }
        for (char c : s.toCharArray()) {
            if (merged[c - 'a']) {
                return null;
            }
            merged[c - 'a'] = true;
            count++;
        }
        max = Math.max(max, count);
        return merged;
    }
}
