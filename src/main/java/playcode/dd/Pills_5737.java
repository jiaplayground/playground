package playcode.dd;

import org.junit.jupiter.api.Test;

//5737 - Pills
public class Pills_5737 {

    public long ways(int N) {
        /**
         *         dp[w][h]  dp[w-1][h-1]
         *                    dp[w][h-1]
         *
         *
         *
         *
         */
        // 1; wh dp[1][1] = dp[1][0]
        //dp[2][2] = dp[2][1] +
        //          // dp[1][1]
        // think about the day w+h, you can take a whole, you can conditionally take half
        long[][] dp = new long[N + 1][N + 1];
        for (int w = 1; w <= N; w++) {
            dp[w][0] = 1;
        }
        for (int w = 1; w <= N; w++) {
            for (int h = 1; h <= w; h++) {
                dp[w][h] = dp[w-1][h]; //take whole
                if (w >= h) { //take half
                    dp[w][h] += dp[w][h-1];
                }
            }
        }
        return dp[N][N];
    }

    @Test
    void t() {
        Pills_5737 p = new Pills_5737();
        long x = p.ways(2);
        long y = p.ways(3);
        long z = p.ways(30);
        long z2 = p.ways(4);
        long w = p.ways(30);
    }


}

/**
 * https://icpcarchive.ecs.baylor.edu/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3748
 * Aunt Lizzie takes half a pill of a certain medicine every day. She starts with a bottle that contains N
 * pills.
 * On the first day, she removes a random pill, breaks it in two halves, takes one half and puts the
 * other half back into the bottle.
 * On subsequent days, she removes a random piece (which can be either a whole pill or half a pill)
 * from the bottle. If it is half a pill, she takes it. If it is a whole pill, she takes one half and puts the
 * other half back into the bottle.
 * In how many ways can she empty the bottle? We represent the sequence of pills removed from the
 * bottle in the course of 2N days as a string, where the i-th character is W if a whole pill was chosen on
 * the i-th day, and H if a half pill was chosen (0 ≤ i < 2N). How many different valid strings are there
 * that empty the bottle?
 * Input
 * The input will contain data for at most 1000 problem instances. For each problem instance there will
 * be one line of input: a positive integer N ≤ 30, the number of pills initially in the bottle.
 * End of input will be indicated by ‘0’.
 * Output
 * For each problem instance, the output will be a single number, displayed at the beginning of a new
 * line. It will be the number of different ways the bottle can be emptied.
 * Sample Input
 * 6
 * 1
 * 4
 * 2
 * 3
 * 30
 * 0
 * Sample Output
 * 132
 * 1
 * 14
 * 2
 * 5
 * 3814986502092304
 */


