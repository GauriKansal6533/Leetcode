class Solution {
    public void dfs(int r,int c,int dr[],int dc[],int vis[][],int grid[][]){
        int m=grid.length;
        int n=grid[0].length;
        vis[r][c]=1;
        for(int k=0; k<4; k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr<m && nr>=0 && nc<n && nc>=0 && grid[nr][nc]==1 && vis[nr][nc]==0){
                dfs(nr,nc,dr,dc,vis,grid);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int i=0; i<m; i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i,0,dr,dc,vis,grid);
            }
            if(grid[i][n-1]==1 && vis[i][n-1]==0){
                dfs(i,n-1,dr,dc,vis,grid);
            }
        }
        for(int j=0; j<n; j++){
            if(grid[0][j]==1 && vis[0][j]==0){
                dfs(0,j,dr,dc,vis,grid);
            }
            if(grid[m-1][j]==1 && vis[m-1][j]==0){
                dfs(m-1,j,dr,dc,vis,grid);
            }
        }
        int count=0;
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