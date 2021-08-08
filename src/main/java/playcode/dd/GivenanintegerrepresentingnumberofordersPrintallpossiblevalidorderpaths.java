package playcode.dd;

import java.util.*;

/*
https://leetcode.com/discuss/interview-question/1146195/DoorDash-or-Software-Engineer-or-Full-Interview
 */
public class GivenanintegerrepresentingnumberofordersPrintallpossiblevalidorderpaths {


    List<String> allPath(int n){
        List<String> result = new ArrayList<>();
        getPaths(result, 0, 0, n, "");
        return result;
    }

    private void getPaths(List<String> result, int p, int d, int n, String curr){
        if(p ==d && p==n){
            result.add(curr);
        }
        if(p>n|| d>n) return;
        getPaths(result, p+1, d, n, curr + "P" + p);
        if(p>d){
            getPaths(result, p, d+1, n , curr + "D" + d );
        }



    }
    public int calculate(String s) {
        int sum =0;
        int size = s.length();
        int lastPos =0;
        int lastOp = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i< size; i++){
            char c = s.charAt(i);
            if(!Character.isDigit   (c) || i == size-1){
                int num = Integer.parseInt(s.substring(lastPos, i));
                if(lastOp=='+'){
                    stack.push(num);
                }
                else if(lastOp=='-'){
                    stack.push(-num);
                }
                else if(lastOp =='*'){
                    stack.push(stack.pop()*num);
                }
                else {
                    stack.push(stack.pop()/num);
                }
                lastPos = i+1;
                lastOp = c;
            }
            else {
                lastOp = c;
            }

        }
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

}
