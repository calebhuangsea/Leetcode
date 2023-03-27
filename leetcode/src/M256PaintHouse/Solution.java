package M256PaintHouse;

public class Solution {
    // OPT(i, j, c): Minimum Cost of index i, j such that we paint color c here
    // Time Complexity O(n) 1ms 75.66%
    // Space Complexity O(n) 43MB 11.81%
    public int minCost(int[][] costs) {
        int m = costs.length;
        int[][] dp = new int[m][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
    }
}
