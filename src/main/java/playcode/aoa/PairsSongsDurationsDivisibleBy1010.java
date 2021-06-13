package playcode.aoa;
import java.util.*;

public class PairsSongsDurationsDivisibleBy1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] ds = new int[60];
        for(int t : time){
            ds[t%60]++;
        }
        int count =0;
        for(int i=0; i<=30; i++){
            if(i ==0 || i ==30){
                count+= ds[i]*(ds[i]-1)/2;
                continue;
            }
            count+= ds[i] * ds[60-i];
        }
        return count;

    }

    public int numPairsDivisibleBy60II(int[] time) {
        //9:05
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            t = t % 60;
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> durations = new ArrayList<>(map.keySet());

        int count = 0;
        //speical cases;

        if (map.get(0) != null) {

            if (map.get(0) > 0) {
                int d0 = map.get(0);
                count = d0 * (d0 - 1) / 2;
            }
            map.remove(0);
        }
        if (map.get(30) != null) {

            if (map.get(30) > 0) {
                int d0 = map.get(30);
                count += d0 * (d0 - 1) / 2;
            }
            map.remove(30);
        }
        for (int d : durations) {
            if (map.get(60 - d) != null) {

                count += map.get(d) * map.get(60-d);
                map.remove(d);
                map.remove(60 - d);

            }
        }
        return count;
    }
}
