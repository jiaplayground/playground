package playcode.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestSubsequenceDistinctCharacters1081 {
    /**
     * cases: current letter c
     * c>peek()
     * stack has C
     * stack has not c
     * <p>
     * c==peek()
     * <p>
     * c<peek()
     * stack has c
     * stack has not c
     * c.is uniq
     */

    public String smallestSubsequence(String s) {

        //"cbacdcbc" bacd
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Deque<Character> stack = new ArrayDeque<>();
        //keep mono-increase stack, except:
        //the letter is the last one

        Set<Character> have = new HashSet<>();
        stack.push(s.charAt(0));
        have.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.peek() < c) {
                if (have.contains(c)) {
                    map.put(c, map.get(c) - 1);
                } else {
                    stack.push(c);
                    have.add(c);
                }
                continue;
            }
            if (c == stack.peek()) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            if (stack.peek() > c) {
                if (have.contains(c)) {
                    map.put(c, map.get(c) - 1);
                } else {
                    while (stack.size() > 0 && stack.peek() > c && map.get(stack.peek()) != null && map.get(stack.peek()) > 1) {
                        char x = stack.pop();
                        map.put(x, map.get(x) - 1);
                        have.remove(x);
                    }
                    stack.push(c);
                    have.add(c);
                }
            }
        }
        String result = "";
        while (stack.size() > 0) {
            result = stack.pop() + result;
        }
        return result;
    }


}
