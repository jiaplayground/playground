package playcode.dp.knapsack;

import org.junit.jupiter.api.Test;

import java.util.*;

public class StickersSpellWord691_TODO {
    public int minStickers(String[] stickers, String target) {
        int size = target.length() + 1;
        int N = 1 << size;
        int[][] dp = new int[stickers.length + 1][size + 1];

        for (int state = 0; state < N; state++) {
            for (int s = 1; s < stickers.length + 1; s++) {
                if (dp[s][state] == 0) continue;
                String st = stickers[s - 1];
                int newState = getState(state, st, target);
                //  dp[s][newState] = Math.min(dp[s][newState]==0 ? Integer.MAX_VALUE : dp[s][newState],

            }

        }

        return 0;

    }

    private int getState(int state, String s, String target) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int newState = state;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if ((state & i << i) == 1) {
                continue;
            }
            if (map.get(c) != null && map.get(c) > 0) {
                newState = newState | 1 << i;
                map.put(c, map.get(c) - 1);
            }
        }
        return newState;

    }


    int[] parent;

    int[][] DIR = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int R = grid1.length;
        int C = grid1[0].length;
        parent = new int[R * C];
        for (int i = 0; i < R * C; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid1[r][c] == 1) {
                    dfs(r, c, grid1);
                }
            }
        }

        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid2[r][c] == 1 && grid1[r][c] != 0) {
                    int root = find(r * C + c);
                    boolean[] isSub = new boolean[]{true};
                    isSub(r, c, grid2, isSub, root);
                    if (isSub[0]) count++;
                }
            }
        }
        return count;

    }

    private void isSub(int r, int c, int[][] grid, boolean[] isSub, int root) {
        int R = grid.length;
        int C = grid[0].length;
        grid[r][c] = -1;
        if (grid[r][c] == 0) return;
        for (int[] dir : DIR) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || grid[nextR][nextC] == 0 || grid[nextR][nextC] == -1) continue;
            if (find(nextR * C + nextC) != root) {
                isSub[0] = false;
            }
            isSub(nextR, nextC, grid, isSub, root);
        }
    }


    int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    void union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p != q) {
            parent[p] = q;
        }
    }

    private void dfs(int r, int c, int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if (r < 0 || r >= R || c < 0 || c >= R) return;
        grid[r][c] = -1;
        if (grid[r][c] == 0) return;
        for (int[] dir : DIR) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || grid[nextR][nextC] == 0 || grid[nextR][nextC] == -1) continue;
            union(r * C + c, nextR * c + nextC);
        }
    }


    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here

        int size = customerQuery.length();
        Queue<String>[] responses = new Queue[size];
        for(String word : repository){
            if(word.charAt(0)!=customerQuery.charAt(0)){
                continue;
            }
            int i =1;
            while(i<word.length() & i<size){
                if(word.charAt(0)!=customerQuery.charAt(0)){
                    break;
                }
                if(responses[i] ==null){
                    responses[i] = new PriorityQueue<>((a,b)-> b.compareTo(a));
                }
                responses[i].offer(word);
                if(responses[i].size()>3) {
                    responses[i].poll();
                }
                i++;
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(int i=1;i<size; i++){
            LinkedList<String> words = new LinkedList<>();
            if(responses[i] == null) break;
            while(!responses[i].isEmpty()){
                words.addFirst(responses[i].poll());
            }
            result.add(words);
        }
        return result;
    }


}
