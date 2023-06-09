package M787CheapestFlightsWithinKStops;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(K * E)
     * Space: O(N)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dp, n);
            for (int[] f : flights) {
                if (temp[f[0]] != Integer.MAX_VALUE) {
                    dp[f[1]] = Math.min(dp[f[1]], f[2] + temp[f[0]]);
                }
            }
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}
