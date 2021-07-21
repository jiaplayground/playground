package playcode.dd;

import java.util.*;

public class LongestIncreasingInMatrix329 {

    /**
     * Optimize
     * 1) sort is not needed
     * 2) visited is not needed. Kind of DAG: always find current < next point
     *
     */


    private int max = 0;
    private int R;
    private int C;
    private static final int[][] DIRS = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        Integer[][] memo = new Integer[R][C];
        for(int r=0; r<R; r++){
            for(int c =0; c<C; c++){
                if(memo[r][c]==null){
                    dfs(r,c, matrix, memo);
                }
            }
        }
        return max;
    }

    private  int dfs(int r, int c, int[][] matrix, Integer[][] memo){
        if(memo[r][c]!=null){
            return memo[r][c];
        }
        int currMax =0;
        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
                    || matrix[r][c] >= matrix[nextR][nextC]) {
                continue;
            }
            currMax = Math.max(currMax, dfs(nextR, nextC, matrix, memo));
        }
        memo[r][c] = 1+ currMax;
        max = Math.max(memo[r][c], max);
        return memo[r][c];
    }


    public int longestIncreasingPathV1(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;

        Integer[][] memo = new Integer[R][C];

        List<int[]> sorted = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sorted.add(new int[]{r, c});
            }
        }
        Collections.sort(sorted, (a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for (int[] point : sorted) {
            if (memo[point[0]][point[1]] == null) {
                boolean[][] visited = new boolean[R][C];
                visited[point[0]][point[1]] = true;
                dfsv2(point[0], point[1], matrix, memo, visited);
            }

        }
        return max;
    }

    private int dfsv2(int r, int c, int[][] matrix, Integer[][] memo, boolean[][] visited) {
        if (memo[r][c] != null) {
            return memo[r][c];
        }
        int currMax = 0;
        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
                    || matrix[r][c] >= matrix[nextR][nextC] || visited[nextR][nextC]) {
                continue;
            }
            visited[nextR][nextC] = true;
            currMax = Math.max(currMax, dfsv2(nextR, nextC, matrix, memo, visited));
            visited[nextR][nextC] = false;
        }
        memo[r][c] = currMax + 1;
        max = Math.max(memo[r][c], max);
        return memo[r][c];
    }



    public int[] threeEqualParts(int[] arr) {
        int count1 =0;
        int[] result = new int[]{-1, -1};
        for(int b : arr){
            if(b==1) count1++;
        }
        if(count1%3!=0) return result;
        int expect1 = count1/3;
        int actual1=0;
        //get third part;
        int pos3=arr.length-1;
        while(pos3>0){
            if(arr[pos3]==1){
                actual1++;
            }
            if(actual1 == expect1){
                break;
            }
            pos3--;
        }
        int endPart1 = checkPart(0, pos3, arr);
        if(endPart1<0) return result;
        int endPart2 = checkPart(endPart1+1, pos3, arr);
        if(endPart2<0) return result;
        return new int[]{endPart1, endPart2};
    }

    private int checkPart(int pos, int pos3, int[]arr){
        while(arr[pos]==0){
            pos++;
        }
        while(pos3<arr.length){
            if(arr[pos] == arr[pos3]){
                if(pos3==arr.length-1){
                    return pos;
                }
                pos++;
                pos3++;
            }
        }
        return -1;
    }
}
