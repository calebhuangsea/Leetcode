package M1254NumberOfClosedIsland;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{
                {0,1,1,1,1,1,1,1},
                {1,0,1,0,0,0,0,1},
                {1,0,1,0,0,1,0,1},
                {1,0,0,0,0,1,0,1},
                {1,0,0,1,0,1,0,1},
                {1,1,0,1,0,0,0,1},
                {1,0,0,0,0,0,0,1},
                {0,1,1,1,1,1,1,1}};
        solution.closedIsland(arr);
    }

    int m;
    int n;
    int[][] grid;

    /**
     * Time Complexity O(M * N) 2ms 82.36%
     * Space Complexity O(M * N) 43.3MB 26.8%
     */
    public int closedIsland(int[][] g) {
        int count = 0;
        this.grid = g;
        m = grid.length;
        n = grid[0].length;
        // from outer land to inner, mark not closed island to be water
        for (int i = 0; i < n; i++) {
            // two rows
            if (grid[0][i] == 0) {
                remove(0, i);
            }
            if (grid[m - 1][i] == 0) {
                remove(m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            // two column
            if (grid[i][0] == 0) {
                remove(i, 0);
            }
            if (grid[i][n - 1] == 0) {
                remove(i, n - 1);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    remove(i, j);

                    count++;
                }
            }
        }
        return count;
    }

    private void remove(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1; // mark current land to be water
        // four direction
        remove(i - 1, j);
        remove(i + 1, j);
        remove(i, j - 1);
        remove(i, j + 1);
    }
}
