class Solution {
    long mod = 2L * (int)1e9;

    int solve(int r, int c, int[][] grid, int[][] dp){
        int m = grid.length, n = grid[0].length;
        
        if(r < 0 ||c < 0) return 0;
        if(grid[r][c] == 1) return dp[r][c] = 0;

        if(dp[r][c] != -1) return dp[r][c];

        if(r == 0 && c == 0){
            return 1;
        }

        int right = (int)(solve(r-1, c, grid, dp) % mod);

        int down = (int)(solve(r, c-1, grid, dp) % mod);

        return dp[r][c] = (int)((right + down) % mod);
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        return solve(m-1, n-1, grid, dp);
    }
}