class Solution {
    private boolean dfs(int node,int color[],int graph[][]){
        
        for(int it:graph[node]){
            if(color[it]==-1){
                color[it]=1-color[node];
                if(dfs(it,color,graph)==false){
                    return false;
                }

            }
            else if (color[it]==color[node]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int color[]=new int[V];
        for(int i=0; i<V; i++){
            color[i]=-1;
        }
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(dfs(i,color,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
}