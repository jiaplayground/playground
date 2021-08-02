package playcode.fb;

import java.util.*;

public class FindAllAnagrams438 {
    /**
     * use Arrays.equals
     *
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] counts = new int[26];
        for(char c : p.toCharArray()){
            counts[c-'a']++;
        }
        List<Integer> matches = new ArrayList<>();
        int[] state = new int[26];
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            state[c]++;
            if(i>=p.length()){
                state[s.charAt(i-p.length())]--;
            }
            if(Arrays.equals(counts, state)){
                matches.add(i-p.length()+1);
            }
        }
        return matches;
    }

    /**
     *  slide window
     */

    public List<Integer> findAnagramsV1(String s, String p) {

        //ab //abbac
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : p.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        } //counts = [a:1; b:1]

        int size = p.length();
        int left = 0;
        int count = counts.size(); //count 2
        var result = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) - 1);
                if (counts.get(c) == 0) { // count =1 counts{a:0 b:1  }
                    count--;              //i=2 count =0; counts {a:0, b:0}
                }
                if(counts.get(c)==-1){
                    count++;
                }
            }    //abb i = 2: c= b counts {a =0 b =-1 } count 1

            //i==3 //abba   counts{a 0, b -1}
            if (i >= size) {
                char leftC = s.charAt(left); // counts {a: 1, b: -1
                if (counts.containsKey(leftC)) { //count =2
                    if (counts.get(leftC) == 0) {
                        count++;
                    }
                    if(counts.get(leftC)== -1){
                        count--;
                    }

                    counts.put(leftC, counts.get(leftC) + 1);

                }
                left++;
            }
            if (count == 0 && i - left + 1 == p.length()) {
                result.add(left);
            }
        }
        return result;
    }
}
