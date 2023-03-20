package M200NumberOfIslands;

/**
 *  Add a count whenever we see an available island, and mark every connected index to be non-island BFS on matrix
 *  Time Complexity: O(N) 3ms 90.52% We almost only visit every element once
 *  Space Complexity: O(1) 51.3MB 33.11% We only change the value in input matrix, n extra memory structure.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    sum += helper(grid, i, j);
                }
            }
        }
        return sum;
    }

    public int helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
        helper(grid, i + 1, j);
        return 1;
    }
}
