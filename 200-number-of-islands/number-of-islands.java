class Solution {

    public void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m ||
            grid[row][col] == '0' || vis[row][col]) {
            return;
        }

        vis[row][col] = true;

        dfs(row - 1, col, grid, vis);
        dfs(row + 1, col, grid, vis);
        dfs(row, col - 1, grid, vis);
        dfs(row, col + 1, grid, vis);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return islands;
    }
}