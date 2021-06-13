package playcode.aoa;
import java.util.*;

public class EarliestLatestRoundsPlayersCompete1900 {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    Set<String> seen = new HashSet<>();
    int first;
    int second;
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        this.first = firstPlayer;
        this.second = secondPlayer;
        List<Integer> players = new ArrayList<>();
        for(int i=1; i<=n; i++){
            players.add(i);
        }
        if(meet(players)){
            return new int[] {1,1};
        }
        dfs(players, new ArrayList<>(), 0, 1);
        return new int[]{min,max};

    }
    private boolean meet(List<Integer> players){
        int idx1= players.indexOf(first);
        int idx2 = players.indexOf(second);
        return (idx1>-1 && idx2>-1 && idx1 == players.size()-1-idx2 );
    }
    private void dfs(List<Integer> players, List<Integer> current, int idx, int round) {
        int size = players.size();
        if(current.size() == (size+1)/2){
            if (!current.contains(first) || !current.contains(second)) {
                return;
            }
            List<Integer> next = new ArrayList<>(current);
            Collections.sort(next);
            if (next.indexOf(first) == next.size() - 1 - next.indexOf(second)) {
                if (round+1 > max) max = round+1;
                if (round+1 < min) min = round+1;
                return;
            }
            if(seen.contains(current.toString())){
                return;
            }
            seen.add(current.toString());
            dfs(next, new ArrayList<>(), 0, round+1);
            return;

        }
        int [] options = new int[]{ players.get(idx), players.get(size -1 -idx) };
        for(int opt : options){
            current.add(opt);
            dfs(players, current, idx + 1,round);
            current.remove(current.size() - 1);
        }
    }
}
