package playcode.fb.pre;

public class ProductArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int prod = 1;
        // [1,2,3] => prefix[1,2,6]// suffix[6,6,3]
        //0: 6
        for (int i = 0; i < size; i++) {
            prod *= nums[i];
            if (prod == 0) {
                break;
            }
            prefix[i] = prod;
        }
        prod = 1;
        for (int i = size - 1; i >= 0; i--) {
            prod *= nums[i];
            if (prod == 0) {
                break;
            }
            suffix[i] = prod;
        }

        int[] result = new int[size];
        result[0] = suffix[1];
        result[size - 1] = prefix[size - 2];
        for (int i = 1; i < size - 1; i++) {
            result[i] = prefix[i - 1] * suffix[i + 1];
        }
        return result;
    }
}
