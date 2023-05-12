package M2140SolvingQuestionsWithBrainpower;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n];
        dp[n - 1] = q[n - 1][0];
        long sum = dp[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // solve this or skip
            long solve = q[i][0];
            if (q[i][1] + i + 1 < n) {
                solve += dp[q[i][1] + i + 1];
            }
            dp[i] = Math.max(solve, dp[i + 1]);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}
