package M1035UncrossedLines;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    public int maxUncrossedLines(int[] n1, int[] n2) {
        // dp[i][j] = line i -> j, maximum line from the left containing this line
        int[][] dp = new int[n1.length][n2.length];
        for (int i = 0; i < n1.length; i++) {
            // for every number in n1, we update the dp
            for (int j = 0; j < n2.length; j++) {
                if (n1[i] == n2[j]) {
                    dp[i][j] += 1;
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                } else {
                    if (i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[n1.length - 1][n2.length - 1];
    }
}
