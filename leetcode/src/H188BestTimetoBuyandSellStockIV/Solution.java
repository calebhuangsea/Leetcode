package H188BestTimetoBuyandSellStockIV;

public class Solution {
    /**
     * Time: O(N*K)
     * Space: O(N*K)
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        // 0 not hold
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int hold = 0; hold < 2; hold ++) {
                    int nothing = dp[i + 1][j][hold];
                    int something;
                    if (hold == 1) {
                        something = dp[i+1][j-1][0] + prices[i];
                    } else {
                        something = dp[i+1][j][1] - prices[i];
                    }
                    dp[i][j][hold] = Math.max(something, nothing);
                }
            }
        }
        return dp[0][k][0];
    }
}
