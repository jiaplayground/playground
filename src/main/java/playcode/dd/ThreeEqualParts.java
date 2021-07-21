package playcode.dd;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int[] result = new int[]{-1, -1};
        int count1 =0;
        for(int b : arr){
            if(b==1) count1++;
        }
        if(count1==0){
            return new int[]{0,2};
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
        return new int[]{endPart1, endPart2+1};
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
            else {
                return -1;
            }
        }
        return -1;
    }
}
