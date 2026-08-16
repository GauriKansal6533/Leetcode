class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int visArray[][]=new int[m][n];
        int distMatrix[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visArray[i][j]=1;
                }
                else{
                    visArray[i][j]=0;
                }
            }
        }
        //directions
        int[] dRow={-1,0,1,0};
        int[] dCol={0,-1,0,1};
        //bfs
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            int steps=cell[2];
            distMatrix[row][col]=steps;
            //neighbours
            for(int i=0; i<4; i++){
                    int nRow=row+dRow[i];
                    int nCol=col+dCol[i];

                    if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && visArray[nRow][nCol]==0){
                        q.add(new int[]{nRow,nCol,steps+1});
                        visArray[nRow][nCol]=1;
                    }
                
            }

        }
        return distMatrix;
        
    }
}