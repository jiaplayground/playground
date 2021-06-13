package playcode.aoa;

import java.util.*;

public class PartitionLabels763 {
    //second, greedy
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> maxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            maxMap.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, maxMap.get(s.charAt(i)));
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }
        return result;
    }

    //segment, then find overlap
    public List<Integer> partitionLabels1(String s) {
        //8:04-> 8:40
        int size = s.length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
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
