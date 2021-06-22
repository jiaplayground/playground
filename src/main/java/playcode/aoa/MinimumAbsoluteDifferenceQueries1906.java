package playcode.aoa;

public class MinimumAbsoluteDifferenceQueries1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        //first observation:
        //sorted array can make it o^n for each query
        //the range is from 1 to 100. bucket sort
        int size = nums.length;
        int[][] map = new int[size+1][101];
        for(int i=1; i<=size; i++){
            //copy
            for(int j=1; j<101; j++){
                map[i][j] = map[i-1][j];
            }
            map[i][nums[i-1]] = map[i-1][nums[i-1]] +1;
        }
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0]+1;
            int end = queries[i][1]+1;
            int last = -1;
            int min = Integer.MAX_VALUE;
            for(int j=1; j<101; j++){
                boolean haveJ = map[end][j] - map[start-1][j] >0;
                if(haveJ){
                    if(last>0) {
                        min = Math.min(min, j - last);
                    }
                    last = j;
                }
            }
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result;
    }
}
