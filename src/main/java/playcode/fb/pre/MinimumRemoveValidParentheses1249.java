package playcode.fb.pre;
import java.util.*;
public class MinimumRemoveValidParentheses1249 {
    /**
     *
     * deque.removeLast() will remove the first push element
     *
     */
    public String minRemoveToMakeValid(String s) {
        int size = s.length();
        //index0: pos; index[1] 0: (  :1 )
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<size; i++){
            char c = s.charAt(i);
            if(c==')'){
                if(stack.isEmpty()){
                    sb.setCharAt(i,'|');
                }
                else {
                    stack.pop();
                }
            }
            else if(c=='(') {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            sb.setCharAt(stack.removeLast(), '|');
        }
        String result = sb.toString();
        result =result.replaceAll("\\|", "");
        return result;
    }
}
