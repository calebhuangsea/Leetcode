package M2466CountWaysToBuildGoodStrings;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int sum = 0;
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        // dp[i] how many ways to construct a string with length i
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero] % mod;
            }
            if (i - one >= 0) {
                dp[i] += dp[i - one] % mod;
            }
            dp[i] %= mod;
            if (i >= low) {
                sum += dp[i];
                sum %= mod;
            }
        }
        return sum;
    }
}
