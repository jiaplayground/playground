package playcode.binaysearch;

//https://www.youtube.com/watch?v=U3U9XMtSxQc
public class KthSmallestElementSortedMatrix378 {
    //image a target;
    // there are k number exactly not bigger than target
    //if decrease this target by one (target -1), then the not bigger than this target will less than k;
    //then this target is the number we are looking for
    public int kthSmallest(int[][] matrix, int k) {
        int R = matrix.length;
        int left = matrix[0][0];
        int right = matrix[R - 1][R - 1];
        int result = 0;
        while (left <= right) {
            int target = left + (right - left) / 2;
            int notBiggerThanCount = notBiggerThan(target, matrix);
            if (notBiggerThanCount >= k) {
                right = target - 1;
            } else {
                left = target + 1;
            }
        }
        return left;
    }

    private int notBiggerThan(int target, int[][] matrix) {
        int R = matrix.length;
        //start from left bottom
        int r = R - 1;
        int c = 0;
        int count = 0;
        while (r >= 0 & c < R) {
            if (matrix[r][c] <= target) {
                count += r + 1;
                c++;
            } else {
                r--;
            }
        }
        return count;
    }
}
