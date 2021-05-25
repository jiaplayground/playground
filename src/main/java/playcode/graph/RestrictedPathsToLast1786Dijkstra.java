package playcode.graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RestrictedPathsToLast1786Dijkstra {
    private static final int MOD = 1_000_000_007;
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        //this is an undirected graph
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], p -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], p -> new HashMap<>()).put(edge[0], edge[2]);
        }
        int[] distanceToLast = getDistanceToLast(n, graph);
       // return countPathBFS(n, distanceToLast, graph);

        return countPathDFS(n, 1, distanceToLast, graph, new Integer[n+1]);
    }

    private int countPathDFS(int target, int from,  int[] distanceToLast, Map<Integer, Map<Integer, Integer>> graph, Integer[] counted){
              if(target==from) return 1;
              if(counted[from]!=null) return counted[from];
              int count =0;
              for(int neighbour : graph.getOrDefault(from, new HashMap<>()).keySet()){
                  if(distanceToLast[from]>distanceToLast[neighbour]){
                      count = (count + countPathDFS(target, neighbour, distanceToLast, graph,counted))/MOD;
                  }
              }
              counted[from] = count;
              return count;
    }

    //dijkstra
    private static final int MAX = Integer.MAX_VALUE;

    private int[] getDistanceToLast(int n, Map<Integer, Map<Integer, Integer>> graph) {
        int[] distanceToLast = new int[n + 1];
        for(int i=1; i<n; i++){
            distanceToLast[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{n, 0});
        Set<Integer> labelled = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] from = pq.poll();
            if(labelled.contains(from[0])) continue;
            distanceToLast[from[0]] = from[1];
            labelled.add(from[0]);
            Map<Integer, Integer> neighbours = graph.get(from[0]);
            if (neighbours == null) continue;
            for (Map.Entry<Integer, Integer> neighbour : neighbours.entrySet()) {
                if (labelled.contains(neighbour.getKey())) continue;
                pq.offer(new int[]{neighbour.getKey(), from[1] + neighbour.getValue()});
            }
        }
        return distanceToLast;
    }

    @Test
    void t(){
        RestrictedPathsToLast1786Dijkstra r = new RestrictedPathsToLast1786Dijkstra();
       int count =  r.countRestrictedPaths(5, new int[][]{{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}});
       count = count -0;
    }

/*
  count by using BFS not working
 */
    private int countPathBFS(int n, int[] distanceToLast, Map<Integer, Map<Integer, Integer>> graph){
        int[] count = new int[n+1];
        count[1] =1;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int from = q.poll();
            for(int neighbour :  graph.getOrDefault(from, new HashMap<>()).keySet()){
                if(distanceToLast[from]>distanceToLast[neighbour]){
                    count[neighbour]= (count[neighbour] +count[from])%MOD;
                    q.offer(neighbour);
                }
            }
        }
        return count[n];
    }


}

