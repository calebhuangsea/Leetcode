package M2352EqualRowandColumnPairs;

public class Solution {
    /**
     * Time: O(N^3)
     * Space: O(1)
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // compare a row to a head
            // [i][0], [i][1], [i][2]
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        break;
                    }
                    count++;
                }
                sum += count == n ? 1 : 0;
            }
        }
        return sum;
    }
}
