package playcode.aoa;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPackage {
    /**
     * Given a list of items in groups, perform certain operations in order to satisfy the constaints required by packaging automation.
     * The conditions are as follows:
     * <p>
     * The first group must contain 1 item only.
     * For all the other groups, the difference between the number of items in adjacent groups must be not greater than 1. In other words, for 1 <= i <= n, arr[i] - arr[i - 1] <= 1. To accomplish this, the following operations are available:
     * Rearrange the groups in any way.
     * Reduce any group to any number that is >= 1.
     * Write an algorithm to find the maximum items that can be packaged for the final group of the list given the conditions above.
     * <p>
     * Example - 1 -- arr = [3, 1, 3, 4]. Output: 4. Explanation: Subtract 1 from the first group making the list [2, 1, 3, 4]. Rearrange the list into [1, 2, 3, 4]. The final maximum of items that can be packaged in the last group is 4.
     * <p>
     * Example 2 - arr = [1, 1, 1, 1]. Output is 1.
     */

    static int getMax(int[] arr) {
        Arrays.sort(arr);
        int size = arr.length;
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[size - 1];
    }

    @Test
    public void t1() {
        int max = getMax(new int[]{1, 100, 1, 2000});
        assertEquals(3, max);

    }

    public List<Integer> partitionLabels(String s) {
        //8:04-> 8:29
        int size = s.length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, new int[]{i, -1});
            } else {
                map.get(c)[1] = i;
            }
        }
        int[][] arr = new int[map.size()][2];
        int id = 0;
        for (int[] se : map.values()) {
            arr[id] = se;
            id++;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<Integer> result = new ArrayList<>();

        //
        int[] last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];
            if (last[1] == -1) {
                result.add(1);
                last = curr;
                continue;
            }
            if (curr[0] < last[1]) {
                last[1] = Math.max(curr[1], last[1]);
                continue;
            }
            result.add(last[1] - last[0] + 1);
            last = curr;
        }
        if (last[1] == -1) {
            result.add(1);
        } else {
            result.add(last[1] - last[0] + 1);
        }
        return result;
    }

}
