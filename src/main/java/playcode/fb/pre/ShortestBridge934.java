package playcode.fb.pre;

import java.util.*;

public class ShortestBridge934 {

    private static int[][] DIRS = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    private int R;
    private int C;
    public int shortestBridge(int[][] grid) {
        this.R = grid.length;
        this.C = grid[0].length;
        //find first island
        //find the bounary of the first island
        //put them into a queue
        //then run dfs to see the min steps to reach the second island
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> boundary = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    visited[r][c] = true;
                    dfs(boundary, grid, visited, r, c);
                    return getShortestBridge(boundary, grid, visited);
                }
            }
        }
        return 0;

    }

    private int getShortestBridge(Queue<int[]> queue, int[][] grid, boolean[][] visited) {
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] from = queue.poll();
                for (int[] dir : DIRS) {
                    int nextR = from[0] + dir[0];
                    int nextC = from[1] + dir[1];
                    if (nextR < 0 || nextR == R || nextC < 0 || nextC == C || visited[nextR][nextC]) {
                        continue;
                    }
                    if (grid[nextR][nextC] == 1) {
                        return steps;
                    }
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
            steps++;
        }
        return 0;

    }
    private void dfs(Queue<int[]> boundary, int[][] grid, boolean[][] visited, int r, int c) {

        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR == R || nextC < 0 || nextC == C || visited[nextR][nextC]) {
                continue;
            }
            if (grid[nextR][nextC] == 0) {
                boundary.offer(new int[]{r, c});
                continue;
            }
            visited[nextR][nextC] = true;
            dfs(boundary, grid, visited, nextR, nextC);
        }
    }

}
