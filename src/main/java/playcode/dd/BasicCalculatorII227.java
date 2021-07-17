package playcode.dd;
import java.util.*;

public class BasicCalculatorII227 {

    public int calculate(String s) {
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


    public int calculatev2(String s) {
        s = s.replaceAll(" ", "");
        int sum = 0;
        for (String part : s.split("\\+")) {
            sum += handlePart(part);
        }
        return sum;
    }

    private int handlePart(String part) {
        String[] units = part.split("-");
        int sum = handleTimesAndDivision(units[0]);
        for (int i = 1; i < units.length; i++) {
            sum -= handleTimesAndDivision(units[i]);
        }
        return sum;
    }

    private int handleTimesAndDivision(String s) {
        int start = 0;
        int sum = 1;
        boolean isTimes = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c) || i == s.length() - 1) {
                int num = Integer.parseInt(s.substring(start, (i == s.length() - 1) ? s.length() : i));
                start = i + 1;
                if (isTimes) {
                    sum *= num;
                } else {
                    sum /= num;
                }
                isTimes = c != '*';
            }
        }
        return sum;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<Integer>> vMap = new HashMap<>();
        int size = nums.length;
        for(int i=0; i<nums.length; i++){
            vMap.computeIfAbsent(nums[i], e->new ArrayList<>()).add(i);
        }
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i<size-3; i++){
            for(int j=i+1; j<size-2; j++){
                for(int k=j+1; k<size-1; k++){
                    int sum3 = nums[i] + nums[k] +nums[j];
                    List<Integer> candidates = vMap.get(target-sum3);
                    if(candidates!=null && candidates.get(candidates.size()-1)>k){
                        result.add(List.of(nums[i], nums[j], nums[k], nums[candidates.get(candidates.size()-1)]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
