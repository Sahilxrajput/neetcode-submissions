class Solution {

    private int fn(int i, int j, int[][] grid, int[][] dp){
        if(i<0 || j<0)
            return Integer.MAX_VALUE;

        if(dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        if(i==0 && j==0)
            return dp[0][0] = grid[0][0];

        int left = fn(i, j-1, grid, dp);
        int up = fn(i-1, j, grid, dp);

        return dp[i][j] = Math.min(left, up) + grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] r: dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        return fn(m-1, n-1, grid, dp);
    }
}