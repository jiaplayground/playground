package playcode.binaysearch;

public class KthMissingPositiveNumber1539 {
    public int findKthPositive(int[] arr, int k) {
        //binary search. key point:
        //find some case to test verify the code logic
        int size = arr.length;
        int left =0; int right = size -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            System.out.println(left + " " + right + " " + mid);
            if(mid+k+1>arr[mid]){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left+k;
    }
}
