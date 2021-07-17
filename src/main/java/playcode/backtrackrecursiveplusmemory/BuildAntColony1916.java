package playcode.backtrackrecursiveplusmemory;

import java.util.*;

public class BuildAntColony1916 {

    /**
     * A
     * /   \
     * B     D
     * |     |
     * C     E
     * 2x2y all combination:
     * 4!/2!/2! * BNode * CNode * Dnode * ENode = 6;
     * for Root A
     * Size  permutatiopn (count ChildNode)
     * totoal children combination / each node combination
     */

    //build a tree
    public int waysToBuildRooms(int[] prevRoom) {
        int N = prevRoom.length;
        List<Integer>[] next = new List[N];
        //[-1,0,0,1,2]
        for(int i=1; i<N; i++){
            if(next[prevRoom[i]]==null){
                next[prevRoom[i]] = new ArrayList<>();
            }
            next[prevRoom[i]].add(i);
        }
        int size[] = new int[N];


        return 10;

    }

    private int dfs(int[] size, List<Integer>[] next, int root){
        if(next[root] == null){
            size[root] =1;
            return 1;
        }
        int count =0;
        for(int node : next[root]){
            count += dfs(size, next, node);
        }
        size[root] = count;
        return count;
    }




}
