package playcode.aoa;
import java.util.*;
public class PrisonCellsAfterNDays957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(n==1){
            return next(cells);
        }
        cells = next(cells);
        n--;
        Map<String, Integer> seen= new HashMap<>();
        int i=0;
        while(i<n){
            String state = Arrays.toString(cells);
            if (seen.get(state)==null){
                seen.put(state, i);
                cells = next(cells);
                i++;
            }
            else {
                int start = seen.get(state);
                n =  n%( i-seen.get(state)+1);
                i=0;
                break;
            }
        }


        return cells;
    }

    private int[] next(int[] cells){
        int[] tmp  = new int[cells.length];
        for(int i=1; i<cells.length -1; i++){
            tmp[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return tmp;
    }

}
