class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans  =new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int sr=0, sc=0, er = m-1, ec=n-1;

        while(sr<=er && sc<=ec){
            //top
            for(int j=sc; j<=ec; j++){
                ans.add(mat[sr][j]);
            }
            sr++;
            
            //right
            for(int i=sr; i<=er; i++){
                ans.add(mat[i][ec]);
            }
            ec--;

            //bottom
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    ans.add(mat[er][j]);
                }
                er--;
            }

            // 4. Left 
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    ans.add(mat[i][sc]);
                }
                sc++;
            }
        }
        return ans;
    }
}
