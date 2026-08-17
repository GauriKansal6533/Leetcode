class Solution {
    public void dfs(int r,int c, int[] dr, int[] dc,int vis[][],char board[][]){
        int m=board.length;
        int n=board[0].length;
        vis[r][c]=1;
        for(int k=0; k<4; k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr<m && nr>=0 && nc<n && nc>=0 && vis[nr][nc]==0 && board[nr][nc]=='O'){
                
                dfs(nr,nc,dr,dc,vis,board);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        if (n == 0 || m == 0) return ;
        int vis[][]=new int[m][n];
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};
        for(int j=0; j<n; j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,drow,dcol,vis,board);
            }
            if(vis[m-1][j]==0 && board[m-1][j]=='O'){
                dfs(m-1,j,drow,dcol,vis,board);
            }

        }
        for(int i=0; i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,drow,dcol,vis,board);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(i,n-1,drow,dcol,vis,board);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        return;
        
    }
}