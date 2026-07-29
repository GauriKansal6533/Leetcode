class Solution {
    public static void dfs(int V,ArrayList<ArrayList<Integer>> adjList,boolean visited[]){
        visited[V]=true;
        for(int neighbour:adjList.get(V)){
            if( visited[neighbour]==false){
                dfs(neighbour,adjList,visited);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        //convert adjmatrix to adjlist
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        //initialize
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
            
        }
        //convert
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(isConnected[i][j]==1 && i!=j){
            adjList.get(i).add(j);
            adjList.get(j).add(i);
        }
            }
        }
        boolean visited[]=new boolean[V];
        int count=0;
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                visited[i]=true;
                dfs(i,adjList,visited);
                count ++;
            }
        }
        return count;
    }
}