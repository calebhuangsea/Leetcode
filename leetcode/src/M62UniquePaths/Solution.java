package M62UniquePaths;

public class Solution {
    /**
     * DP OPT(i, j) = OPT(i - 1, j) + OPT(i, j - 1)
     * Time Complexity: O(mn) 0ms 100%
     * Space Complexity: O(mn) 39.3MB 49.5%
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Math: Choose N/M from M+N
     * Time Complexity: O(MN) 0ms 100%
     * Space Complexity: O(1) 40.8Mb 10.13%
     */

//    public int uniquePaths(int m, int n) {
//        m -= 1;
//        n -= 1;
//        long sum = 1;
//        for (int i = 1; i <= n; i++) {
//            sum *= (i + m);
//            sum /= i;
//        }
//        return (int)sum;
//    }
}
