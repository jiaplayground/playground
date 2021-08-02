package playcode.fb;
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        int left =0;
        int max =0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(posMap.containsKey(c)){
                left = Math.max(left,posMap.get(c)+1 ); //jump left
                /* remove appraoch
                int newLeft = posMap.get(c)+1;
                for(;left<newLeft; left++){
                    posMap.remove(s.charAt(left));
                }*/
            }
            posMap.put(c, i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }



}
