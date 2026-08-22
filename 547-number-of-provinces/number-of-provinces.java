class Solution {
    public void dfs(int node,int vis[],int isConnected[][]){
        int n=isConnected.length;
        vis[node]=1;
        for(int neighbour=0; neighbour<n; neighbour++){
            if(isConnected[node][neighbour]==1 &&vis[neighbour]==0){
                dfs(neighbour,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int vis[]=new int[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                provinces++;
                dfs(i,vis,isConnected);
            }
            }
        
        return provinces;
        
    }
}