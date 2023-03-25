package H980UniquePathsIII;

public class Solution {
    /**
     * Backtracking simple
     * Time Complexity O(3^n) 0ms 100% we have 3 direction to try if we ignore the direction we come from
     * Space Complexity O(1) 40.2MB 39.49%
     */
    public int uniquePathsIII(int[][] grid) {
        int startI = -1;
        int startJ = -1;
        int endI = -1;
        int endJ = -1;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                } else if (grid[i][j] == 2) {
                    endI = i;
                    endJ = j;
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return helper(grid, endI, endJ, startI, startJ, count + 1);
    }

    public int helper(int[][] grid, int x, int y, int i, int j, int left) {
        if(x == i && y == j) {// if we hit the end point
            return left == 0 ? 1 : 0;
        }
        // four directions
        // left
        int sum = 0;
        grid[i][j] = -1;
        if (j - 1 >= 0 && grid[i][j - 1] != -1) {
            sum += helper(grid, x, y, i, j - 1, left - 1);
        }
        // up
        if (i - 1 >= 0 && grid[i - 1][j] != -1) {
            sum += helper(grid, x, y, i - 1, j, left - 1);
        }
        // right
        if (j + 1 < grid[x].length && grid[i][j + 1] != -1) {
            sum += helper(grid, x, y, i, j + 1, left - 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] != -1) {
            sum += helper(grid, x, y, i + 1, j, left - 1);
        }
        grid[i][j] = 0;
        return sum;
    }
}
