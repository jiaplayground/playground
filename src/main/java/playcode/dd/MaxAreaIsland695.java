package playcode.dd;

public class MaxAreaIsland695 {
    private static final int[][] DIRS = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };
    int max =0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int r=0; r<grid.length;r++){
            for(int c=0; c<grid[0].length; c++){
                int[] count = new int[]{0};
                if(!visited[r][c] && grid[r][c] == 1){
                    visited[r][c] = true;
                    dfs(visited, grid, r,c, count);
                }
                max = Math.max(max, count[0]);
            }
        }
        return max;
    }

    private void dfs( boolean[][] visited,int[][] grid, int r, int c, int[] count){
        count[0]++;
        for(int[] dir : DIRS){
            int nextR = dir[0]+r;
            int nextC = dir[1]+c;
            if(nextR<0 || nextR>=grid.length || nextC<0 || nextC>=grid[0].length){
                continue;
            }
            if(visited[nextR][nextC] || grid[nextR][nextC] ==0) continue;
            visited[nextR][nextC] = true;
            dfs(visited,grid, nextR, nextC, count);
        }
    }
}
