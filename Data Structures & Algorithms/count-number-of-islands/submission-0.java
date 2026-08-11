class Solution {

    private void dfs(int r, int c, char[][]grid, boolean[][] vis){
        int m = grid.length, n = grid[0].length;
        
        if(vis[r][c] != false) return;
        
        vis[r][c] = true;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int[]dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nc<n && nr<m && nc>=0 && nr>=0 && grid[nr][nc] == '1' && !vis[nr][nc]){
                dfs(nr, nc, grid, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int islands =0;

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    islands++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return islands;
    }
}
