class Solution {

    int dfs(int r, int c, int[][] mat, int[][] dp){
        int m = mat.length, n =mat[0].length;
        
        if(dp[r][c] != -1) 
            return dp[r][c];

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int maxLen = 1;

        for(int[] d : dirs){
            int nr = r +d[0];
            int nc = c +d[1];

            if(nr<m && nc<n && nr>=0 && nc>=0 && mat[nr][nc] > mat[r][c]){
                maxLen = Math.max(maxLen, 1 + dfs(nr, nc, mat, dp));
            }
        }

        return dp[r][c] = maxLen;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n =matrix[0].length;
        int[][] dp = new int[m][n];
        int maxi = 0;

        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxi = Math.max(dfs(i, j, matrix, dp), maxi);
            }
        }

        return maxi;
    }
}
