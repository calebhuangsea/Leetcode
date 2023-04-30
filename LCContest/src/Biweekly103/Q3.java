package Biweekly103;

public class Q3 {
    int m;
    int n;
    int max = 0;
    int curr = 0;
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n= grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    curr = 0;

                    max = Math.max(curr, max);
                }
            }
        }
        return max;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i ==m || j ==n || grid[i][j] == 0) {
            return;
        }
        curr += grid[i][j];
        grid[i][j] = 0;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
