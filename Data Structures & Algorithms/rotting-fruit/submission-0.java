class Solution {

    record Pair(int r, int c) {}

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                } 
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int cnt = 0;

        int[][] dirs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();

                for (int[] d : dirs) {
                    int nr = cur.r() + d[0];
                    int nc = cur.c() + d[1];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1 &&
                        !vis[nr][nc]) {

                        vis[nr][nc] = true;
                        q.offer(new Pair(nr, nc));
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? cnt - 1 : -1;
    }
}