package playcode.fb;

import java.util.*;

public class DiagonalTraverse498 {

    /**
     * observation
     * 1) r+c same, in the same layer;
     * 2)r+c %2 =0  start from r=0 to
     * r+c %2 ==1. c=0
     */

    public int[] findDiagonalOrder(int[][] mat) {
        int nR = mat.length;
        int nC = mat[0].length;
        int[] result = new int[nR * nC];
        int counter=0;
        for (int layer = 0; layer < nR + nC - 1; layer++) {
            if(layer%2==0){
               // int r=0;
                for(int r=0;r < Math.min(layer, nR);r++ ){
                    int c = layer-r;

                }


            }

        }


        return null;
    }




    public int[] findDiagonalOrder_V1(int[][] mat) {
        // https://leetcode.com/problems/diagonal-traverse/discuss/203060/Java-Solution-with-Clear-Explanation
        //   00-> (01, 10, 20, 11, 02, 12, 2,1, 22)
        int nR = mat.length;
        int nC = mat[0].length;
        int[] result = new int[nR * nC];
        Map<Integer, List<Integer>> cellGroup = new HashMap<>();
        for (int r = 0; r < nR; r++) {
            for (int c = 0; c < nC; c++) {
                int sum = r + c;
                cellGroup.computeIfAbsent(sum, e -> new ArrayList<>()).add(mat[r][c]);
            }
        }
        int count = 0;
        for (int i = 0; i < nR + nC - 1; i++) {
            List<Integer> layer = cellGroup.get(i);
            if (i % 2 == 0) {
                Collections.reverse(layer);
            }
            for (int v : layer) {
                result[count++] = v;
            }
        }
        return result;
    }


}
