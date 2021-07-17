package playcode.dd;
import java.util.*;
public class BasicCalculator224_TODO {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s =s.replaceAll("\\+-", "-");
        Deque<String> stack = new ArrayDeque<>();
        //3+124*(4*(5-6)*(8+9))
        for(char c : s.toCharArray()){

        }
        return 0;


    }
    public int calculateWithoutP(String s) {
        Deque<Integer> stack =new ArrayDeque<>();
        s = s.replaceAll(" ", "");
        int start =0;
        int size = s.length();
        char lastOp = '+';
        for(int i=0; i<size; i++ ) {
            char c = s.charAt(i);
            if(!Character.isDigit(c) || i == size-1){
                int num = Integer.parseInt(s.substring(start, i==size-1 ? size : i));
                start = i+1;
                if(lastOp == '+'){
                    stack.push(num);
                }
                else if(lastOp=='-'){
                    stack.push(-num);
                }
                else if(lastOp=='*'){
                    stack.push(stack.pop() * num);
                }
                else {
                    stack.push(stack.pop()/num);
                }
                lastOp = c;
            }
        }
        int sum =0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
