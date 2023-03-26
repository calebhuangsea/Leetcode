package M63UniquePathsII;

public class Solution {
    /**
     * DP Same as one
     * Time Complexity O(mn) 0ms 100%
     * Space Complexity O(mn) 42.2MB 16.97%
     */
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (arr[i][0] != 1 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[0][i] != 1 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
