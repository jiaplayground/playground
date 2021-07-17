package playcode.prefix;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestAwesomeSubstring1542 {

    public int longestAwesome(String s) {
        int state = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int max =1;
        for(int i =0; i<s.length(); i++){
            int c = s.charAt(i)-'0';
            state = state ^ (1<<c);
            //compare with current state i and theJ=( j-1) state
            //So the state is length is i-J
            // "4121"  when i = 3, it compare with j =1;
            if(map.containsKey(state)){
                max = Math.max(max, i- map.get(state));
            }
            for(int j=0; j<10; j++){
                int oneOdd = state ^(1<<j);
                if(map.containsKey(oneOdd)){
                    max = Math.max(max, i- map.get(oneOdd));
                }
            }
            if(!map.containsKey(state)){
                map.put(state, i);
            }
        }
        return max;
    }

    @Test
    void test() {
        LongestAwesomeSubstring1542 t = new LongestAwesomeSubstring1542();
        t.longestAwesome("010");
    }
}
