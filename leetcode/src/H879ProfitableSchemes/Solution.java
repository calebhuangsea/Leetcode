package H879ProfitableSchemes;

public class Solution {
    /**
     * Time: O(N * P * K)
     * Space: O(101 ^3)
     */
    int mod = (int)1e9+7;
    public int profitableSchemes(int N, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][N + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int p = profit[k];
            int n = group[k];
            for (int i = P; i >= 0; i--) {
                for (int j = N - n; j>= 0; j--) {
                    dp[Math.min(P, p + i)][j + n] = (dp[i][j] + dp[Math.min(P, p + i)][j + n]) % mod;
                }
            }
        }
        int sum = 0;
        for (int x : dp[P]) sum = (sum + x) % mod;
        return sum;
    }
}
