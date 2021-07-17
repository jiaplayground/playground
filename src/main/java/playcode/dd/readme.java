package playcode.dd;
import java.util.*;
//姨散吾韭，漆悟汣，议尓仐午，衣饵二舅，流旧物
/*
1383	Maximum Performance of a Team
1359	Count All Valid Pickup and Delivery Options
759	Employee Free Time
695	Max Area of Island
1229	Meeting Scheduler
210	Course Schedule II
355	Design Twitter
1472	Design Browser History
1174	Immediate Food Delivery II
1197	Minimum Knight Moves
1173	Immediate Food Delivery I
795	Number of Subarrays with Bounded Maximum
37	Sudoku Solver
121	Best Time to Buy and Sell Stock
227	Basic Calculator II
348	Design Tic-Tac-Toe
973	K Closest Points to Origin
36	Valid Sudoku
329	Longest Increasing Path in a Matrix
269	Alien Dictionary
986	Interval List Intersections
56	Merge Intervals
200	Number of Islands
146	LRU Cache
15	3Sum
 */
public class readme {
    Map<Integer, int[]> memo =  new HashMap<>();
    int max =0;
    public int maxLength(List<String> arr) {
        // a abc bc ea d
        helper(0, arr, 0, new boolean[26]);
        return max;

    }
   private void helper(int pos, List<String> arr, int state, boolean [] uniq){
        if(pos==arr.size()){
            return;
        }
        for(int i=pos; i<arr.size(); i++){
            boolean[] merged = merge(uniq, arr.get(pos));
            if(merged!=null){
                helper(pos+1, arr, state, merged);
            }
            helper(pos+1, arr,state, uniq);
        }
    }
    private boolean [] merge(boolean[] uniq, String s){
        boolean[] merged = new boolean[26];
        int count =0;
        for(int i=0; i<26; i++){
            if(uniq[i]){
                merged[i] = uniq[i];
                count++;
            }
        }

        for(char c : s.toCharArray() ){
            if(merged[c-'a']){
                return null;
            }
            merged[c-'a'] = true;
            count++;
        }
        max = Math.max(max, count);
        return merged;
    }
}
