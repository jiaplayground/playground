package playcode.mattrix;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSumRectangleNoLargerhanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        // sum(x,y, x1,y1) = sum(x, y) -sum(x1,y) - sum(x, y1) + sum(x1,y1)
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] preSum = new int[R][C];
//[[1, 0, 1],
// [0,-2, 3]]
        for(int r=0; r<R; r++){
            int sum =0;
            for(int c=0; c<C; c++) {
                sum += matrix[r][c];
                preSum[r][c] = r>0 ? sum + preSum[r-1][c] : sum;
                System.out.println(c + " " + r + "::" +  preSum[r][c]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++){
                for(int r1=0; r1<=r; r1++){
                    for(int c1=0; c1<=c; c1++){
                        int value = preSum[r][c] -preSum[r][c1] - preSum[r1][c] + preSum[r1][c1];
                        if(value==k){
                            return k;
                        }
                        if(value<k){
                            max = Math.max(value, max);
                        }
                    }
                }
            }
        }
        return max;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int size = dist.length;
        Double[] time = new Double[size];
        for(int i=0; i<size; i++){
            time[i] = 1.0*dist[i]/speed[i];
        }
        Arrays.sort(time, Comparator.comparingDouble(a -> a));
        int count =1;
        for(int i=1; i<size; i++){
            if(time[i] < 1.00 *i){
                count++;
            }
        }
        return count;
    }

    private static final int MOD  = 1_000_000_007;
    public int countGoodNumbers(long n) {
        //10^9 + 7
        //f(n) = i is even 0,2,4,6,8
        //f(n) i is odd: 1,3,5,7
        long count = 1L;
        for(long i=0; i < n; i++){
            if(i % 2==0){
                count = count * 5 % MOD;
            }
            else {
                count = count * 4 % MOD;
            }
        }
        return (int )count;

    }

}
