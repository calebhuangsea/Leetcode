package M276PaintFence;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            int diff = (k - 1) * dp[i - 1];
            int same = dp[i - 2] * (k - 1);
            dp[i] = diff + same;

        }
        return dp[n - 1];
    }
}
