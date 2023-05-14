package Weekly345;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // right to left dp
        int[][] dp = new int[m][n];
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                }
                if (i + 1 < m && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(dp[i][0], max);
        }
        return max;
    }

}
