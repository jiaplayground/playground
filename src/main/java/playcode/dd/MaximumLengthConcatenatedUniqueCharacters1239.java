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

    private int maxUniqLetter =0;
    public int maxLengthV2(List<String> arr) {
        List<String> uniqString = new ArrayList<>();
        for(String str : arr){
            int state =0;
            for(char c : str.toCharArray()){
                int numChar = c-'a';
                if((state & (1<< numChar) ) > 0){
                    state =0;
                    break;
                }
                state ^= (1<<numChar);
            }
            if(state>0){
                uniqString.add(str);
            }
        }
        dfs(0, uniqString, 0, 0);
        return maxUniqLetter;
    }


    private void dfs(int start, List<String> arr, int state, int  count){
        /**
         * Key point is to check the max count in very loop.
         * should not wait until start == arr.size()
         */
        maxUniqLetter = Math.max(count, maxUniqLetter);
        if(start == arr.size()){
            return;
        }
        for(int i= start; i<arr.size(); i++){
            int nextState = state;
            int nextCount = count;
            for(char c : arr.get(i).toCharArray()){
                int num = c-'a';
                if((state & (1<<num))>0){
                    nextState = state;
                    break;
                }
                nextState ^= (1<<num);
                nextCount++;
            }
            if(nextState!=state){
                dfs(i+1, arr, nextState, nextCount);
            }
        }
    }
}
