package H265PaintHouseII;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(N * K ^ 2)
     * Space: O(N * K)
     */
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        //
        int[][] dp = new int[n][k];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE / 5);
        }
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int z = 0; z < k; z++) {
                    if (j != z) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][z] + costs[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
