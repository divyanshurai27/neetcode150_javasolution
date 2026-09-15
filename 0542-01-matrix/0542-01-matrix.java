class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dist = new int[n][m];

        // Put all 0s in queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    dist[nrow][ncol] == -1) {

                    dist[nrow][ncol] = dist[row][col] + 1;

                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        return dist;
    }
}