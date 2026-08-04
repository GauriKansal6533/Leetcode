class Solution {

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       int[] vis, int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int neighbour : adj.get(node)) {

            // If not visited, perform DFS
            if (vis[neighbour] == 0) {
                if (dfs(neighbour, adj, vis, pathVis)) {
                    return true;
                }
            }

            // If already in current DFS path -> cycle found
            else if (pathVis[neighbour] == 1) {
                return true;
            }
        }

        // Remove from current DFS path while backtracking
        pathVis[node] = 0;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        // Check every component
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return false; // Cycle exists
                }
            }
        }

        return true; // No cycle
    }
}