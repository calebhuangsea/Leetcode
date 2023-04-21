package M695MaxAreaofIsland;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(1)
     */
    int m;
    int n;
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) {
            return 0;
        }
        int curr = 1;
        grid[i][j] = 0;
        curr += dfs(grid, i + 1, j);
        curr += dfs(grid, i - 1, j);
        curr += dfs(grid, i, j + 1);
        curr += dfs(grid, i, j - 1);
        return curr;
    }
}
