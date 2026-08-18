class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int [m][n];
        Queue<int[]> q=new LinkedList<>();
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};
        int count=0;
        //put boundary 1s to queue
        for(int i=0; i<m; i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                vis[i][0]=1;
                q.add(new int[]{i,0});
            }
            if(grid[i][n-1]==1 && vis[i][n-1]==0){
                vis[i][n-1]=1;
                q.add(new int[]{i,n-1});
    
            }
        }
        for(int j=0; j<n; j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                vis[0][j]=1;
                q.add(new int[]{0,j});
            }
            if(grid[m-1][j]==1 && vis[m-1][j]==0){
                vis[m-1][j]=1;
                q.add(new int[]{m-1,j});
            }
        }
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int r=cell[0];
            int c=cell[1];
            
            for(int k=0; k<4; k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr<m && nr>=0 && nc<n && nc>=0 && grid[nr][nc]==1 && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                    
                    
                }
            }
            
        }
        for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]==1 && vis[i][j]==0){
                        count++;
                    }
                }
            }
        return count;
        
    }
}