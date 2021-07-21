package playcode.dd;

import java.util.*;

public class MaximumLengthConcatenatedUniqueCharacters1239 {
    //Integer.toBinaryString(newStates)
    // binary operation : ^ & |
    /**
     * basically a subset problem:
     * we have two parts: chosen and unchosen:
     * each time pick an unchosen element.
     *
     */
    int max = 0;

    public int maxLength(List<String> arr) {
        dfs(0, 0, 0, arr);
        return max;
    }

    private void dfs(int states, int count, int pos, List<String> arr) {
        for (int i = pos; i < arr.size(); i++) {
            int newStates = states;
            int newCount = count;
            for (char ch : arr.get(i).toCharArray()) {
                int state = ch - 'a';
                if ((newStates & (1 << state)) > 0) {
                    newCount = count;
                    break;
                } else {
                    newStates |= (1 << state);
                    newCount++;
                }
            }
            if (newCount > count) {
                max = Math.max(max, newCount);
                dfs(newStates, newCount, i + 1, arr);
            }
        }
    }
}
