package playcode.aoa;

public class PreviousPermutationOneSwap1053 {
    /**
     *step 1 find a point arr[i] >arr[i+1]
     * step 2: find a max arr[j] smaller then arr[i] in i+1: size -1
     *         if(arr[j] = arr[j-1])  take j-1
     *
     */

    public int[] prevPermOpt1(int[] arr) {
        int size = arr.length;
        //find max in i+1 : size-1
        int max = size-1;
        for(int i=size-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                while(max>i && (arr[i]< arr[max] || arr[max]==arr[max-1])){
                    max--;
                }
                swap(i, max, arr);
                return arr;
            }
        }
        return arr;
    }
    void swap(int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }
}
