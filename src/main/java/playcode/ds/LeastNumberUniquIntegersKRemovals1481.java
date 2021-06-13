package playcode.ds;

import java.util.*;
public class LeastNumberUniquIntegersKRemovals1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int[] freqs = new int[map.size()];
        int i=0;
        for(int n : map.values()){
            freqs[i] = n;
            i++;
        }
        Arrays.sort(freqs);
        int size = freqs.length;
        for(int t=0; t< size; t++){
            if(k-freqs[t]==0){
                return size-1-t;
            }
            else if(k-freqs[t]<0){
                return size-t;
            }
            k-=freqs[t];
        }
        return size;
    }

}
