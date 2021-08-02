package playcode.fb;

public class MaximumSum3Subarrays689 {

   //if         int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
    //        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];

    /**
     * get suffix k_subArray max from right  to left
     * then get prefix k_subArray max from left to right.
     * In the same time
     *
     */

    static class Max {
        int start;
        int val;
        public Max(int start, int val){
            this.start = start;
            this.val = val;
        }
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];
        int max3 =0;
        int size = nums.length;
        Max[] prefixMax = new Max[size];
        Max[] suffixMax = new Max[size];
        int sumK =0;
        for(int i=size-1; i>0; i--){
            sumK += nums[i];
            if(size-i>k){
                sumK -= nums[i+k];
            }
            if(i<size-k) continue;
            if(suffixMax[i+1]==null || sumK>= suffixMax[i+1].val){
                suffixMax[i] = new Max(i,sumK);
            }
            else {
                suffixMax[i] = suffixMax[i+1];
            }
        }
        //[1 ,2, 1, 2, 6, 7, 5]
        sumK=0;
        for(int i=0; i<size-1-k; i++){
            sumK += nums[i];
            if(i>=k){
                sumK -= nums[i-k];
            }
            // k =1 trouble
            if(i==k-1 || prefixMax[i-1].val<sumK){
                prefixMax[i] = new Max(i-k+1, sumK);
            }
            else if(i>=k) {
                prefixMax[i] = prefixMax[i-1];
            }

            if(i >= 2*k-1){
                int localMax3 = sumK + prefixMax[i-k].val + suffixMax[i+1].val;
                if(localMax3 > max3){
                    result = new int[]{prefixMax[i-k].start, i-k+1, suffixMax[i+k].start};
                    max3 = localMax3;
                }
            }

        }
        return result;
    }
}
