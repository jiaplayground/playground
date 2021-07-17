package playcode.dd;
import java.util.*;
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }
    void dfs(List<List<Integer>> result, int[] nums, List<Integer> curr, int pos){
        result.add(new ArrayList<>(curr));

        for(int i=pos; i<nums.length; i++){
            curr.add(nums[i]);
            dfs(result, nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets_V2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            subsetHelper(result, new ArrayList<Integer>(), 0, i, nums);
        }
        return result;

    }

    private void subsetHelper(List<List<Integer>> result, List<Integer> list, int start, int L, int[] nums) {
        if (L == list.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsetHelper(result, list, i + 1, L, nums);
            list.remove(list.size() - 1);
        }
    }
}
