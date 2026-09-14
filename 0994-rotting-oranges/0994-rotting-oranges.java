class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]>q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int cntfresh = 0;

        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        } int time= 0;
          int cnt = 0;
           
         int[] drow = {-1,0,1,0};
         int [] dcol = {0,1,0,-1};

         while(!q.isEmpty()){
            int [] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int t= curr[2];

            time= Math.max(time,t);

            for(int i = 0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
              if (nrow >= 0 && nrow < n &&  ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1)
                    { 
                        q.offer(new int[]{nrow,ncol,t+1});
                        vis[nrow][ncol] =2 ;
                        cnt++;
                    
                    } 
            }
         } 
               if(cnt != cntfresh){
                return -1;
               }
               return time;
    }
}