package src.M1905CountSubIslands;

public class Solution {
    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    int m;
    int n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n || grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        boolean flag = grid1[i][j] == 1;
        flag &= dfs(grid1, grid2, i + 1, j);
        flag &= dfs(grid1, grid2, i - 1, j);
        flag &= dfs(grid1, grid2, i, j + 1);
        flag &= dfs(grid1, grid2, i, j - 1);
        return flag;
    }
}
