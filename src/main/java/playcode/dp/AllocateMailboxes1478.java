package playcode.dp;

import java.util.*;

public class AllocateMailboxes1478 {

    int getDist(int left, int right, int[] houses) {
        int median = (right + left) / 2;
        int dist = 0;
        int target = houses[median];
        for (int i = left; i <= right; i++) {
            dist += Math.abs(target - houses[i]);
        }
        return dist;

    }

    //the run time complexity is  n^4 minDistance1
    // can optimize to n^3 by pre-compute the distance if i:j has one mailbox
    public int minDistance(int[] houses, int k) {
        int size = houses.length;
        if (k >= size) return 0;
        Arrays.sort(houses);
        int[][] range = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                range[i][j] = getDist(i, j, houses);
            }
        }
        int[][] dp = new int[size][k];
        for (int i = 0; i < size; i++) {
            dp[i][0] = getDist(0, i, houses);
        }
        for (int i = 1; i < size; i++) {
            for (int t = 1; t <= Math.min(i, k - 1); t++) {
                //i =1; t=1, divide by two: dp[0][0] +
                dp[i][t] = Integer.MAX_VALUE;
                for (int j = t; j <= i; j++) {
                    dp[i][t] = Math.min(dp[i][t], dp[j - 1][t - 1] + range[j][i]);
                }
            }
        }
        return dp[size - 1][k - 1];
    }


    public int minDistance1(int[] houses, int k) {
        int size = houses.length;
        int[][] dp = new int[size][k];
        if (k >= size) return 0;
        Arrays.sort(houses);
        for (int i = 0; i < size; i++) {
            dp[i][0] = getDist(0, i, houses);
        }

        for (int i = 1; i < size; i++) {
            for (int t = 1; t <= Math.min(i, k - 1); t++) {
                //i =1; t=1, divide by two: dp[0][0] +
                dp[i][t] = Integer.MAX_VALUE;
                for (int j = t; j <= i; j++) {
                    dp[i][t] = Math.min(dp[i][t], dp[j - 1][t - 1] + getDist(j, i, houses));
                }
            }
        }
        return dp[size - 1][k - 1];
    }

}
