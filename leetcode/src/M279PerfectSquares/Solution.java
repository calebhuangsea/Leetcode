package M279PerfectSquares;

import java.util.Arrays;

public class Solution {
    /**
     * Time Complexity O(N * sqrt(N)) 37ms 62.96%
     * Space Complexity O(N) 42.1MB 46.48%
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = n;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
