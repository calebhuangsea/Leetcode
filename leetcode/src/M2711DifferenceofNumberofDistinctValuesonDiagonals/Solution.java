package M2711DifferenceofNumberofDistinctValuesonDiagonals;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Time: O(N^3)
     * Space: O(N^2)
     */
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> tl = new HashSet<>();
                Set<Integer> lr = new HashSet<>();
                int t = 1;
                while (i - t >= 0 && j - t >= 0) {
                    tl.add(grid[i- t][j - t]);
                    t++;
                }
                t = 1;
                while (i + t < m && j + t < n) {
                    lr.add(grid[i + t][j + t]);
                    t++;
                }
                res[i][j] = Math.abs(tl.size() - lr.size());
            }
        }
        return res;
    }
}
