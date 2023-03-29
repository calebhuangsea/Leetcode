package M221MaximalRectangle;

public class Solution {
    // OPT(i, j) maximum size from 0,0 to i,j
    /**
     * Time Complexity O(mn) 6ms 75.95%
     * Space Complexity O(mn) 54MB 52.98%
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1:0;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1:0;
            max = Math.max(dp[0][i], max);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][ j - 1]));
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
