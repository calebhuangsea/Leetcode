package M72EditDistance;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    public int minDistance(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        // minimum op to convert 0...i to 0...j
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    // replace into i, delete i, insert into i
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
