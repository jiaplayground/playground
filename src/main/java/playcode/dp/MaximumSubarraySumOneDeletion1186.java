package playcode.dp;

public class MaximumSubarraySumOneDeletion1186 {
    public int maximumSum(int[] arr) {
        //state == optional in backtrack
        //dp[i] = state new / or continue
        //        or delte, or no delete
        int deleted = arr[0];
        int noDel = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            deleted = Math.max(noDel, deleted + arr[i]);
            noDel = Math.max(arr[i], arr[i] + noDel);
            max = Math.max(max, Math.max(deleted, noDel));
        }
        return max;
    }
}
