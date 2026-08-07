class Solution {

    void fillCol(int c, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][c] = 0;
        }
    }

    public void setZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // 1. Check if first column has any zero
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 2. Check if first row has any zero
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 3. Use first row and column as markers for the rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // 4. Update inner cells (1..m-1, 1..n-1) using the markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // 5. Zero out the first row if needed
        if (firstRowZero) {
            Arrays.fill(mat[0], 0);
        }

        // 6. Zero out the first column if needed
        if (firstColZero) {
            fillCol(0, mat);
        }
    }
}