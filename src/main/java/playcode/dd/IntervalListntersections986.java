package playcode.dd;

import java.util.*;

public class IntervalListntersections986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            if (first[0] > second[1]) {
                j++;
            } else if (second[0] > first[1]) {
                i++;
            } else {
                result.add(new int[]{
                        Math.max(first[0], second[0]),
                        Math.min(first[1], second[1])
                });
                if (first[1] > second[1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[][] out = new int[result.size()][2];
        for (int s = 0; s < result.size(); s++) {
            out[s] = result.get(s);
        }
        return out;
    }
}
