package playcode.dd;


import java.util.*;

public class MinimumKnightMoves1197 {

    private static int[][] NEXTS = new int[][]{
            {2, 1}, {1, 2},
            {-2, 1}, {-1, 2},
            {2, -1}, {1, -2},
            {-2, -1}, {-1, -2}
    };

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[301][301];
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{0, 0});
        if (x == 0 && y == 0) return 0;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                step++;
                for (int[] next : NEXTS) {
                    int[] from = q.poll();
                    int nextX = from[0] + next[0];
                    int nextY = from[1] + next[y];
                    if (nextX == x && nextY == y) {
                        return step;
                    }
                    if (!visited[nextX][nextY]) {
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return step;
    }
}
