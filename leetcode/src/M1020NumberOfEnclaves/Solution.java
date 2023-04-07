package M1020NumberOfEnclaves;

public class Solution {
    /**
     * BFS
     * Time Complexity O(MN) 7ms 97.85%
     * Space Complexity O(1) 53.5MB 74.9%
     */
    int m;
    int n;
    int[][] grid;
    public int numEnclaves(int[][] g) {
        m = g.length;
        n = g[0].length;
        this.grid = g;
        // bfs to mark all 1 accessible from the border to 0
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i);
            }
            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i);
            }
        }
        // then iterate through it again to find how many grid 1 left
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
