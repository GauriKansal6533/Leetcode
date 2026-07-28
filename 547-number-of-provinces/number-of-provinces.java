class Solution {
    public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
        visited[node]=true;
        for(int neighbour:adjList.get(node)){
            if(visited[neighbour]==false){
                dfs(neighbour,visited,adjList);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int node=isConnected.length;
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<node;i++){
            adjList.add(new ArrayList<>());

        }
        //convert matrix to list
        for(int i=0; i<node;i++){
            for(int j=0; j<node;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean visited[]=new boolean[node];
        int count=0;
        for(int i=0; i<node; i++ ){
            if(!visited[i]){
                count++;
                dfs(i,visited,adjList);
            }
        }
        return count;
        
    }
}