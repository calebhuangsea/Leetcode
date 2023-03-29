package M91DecodeWays;

public class Solution {
    // dp[i] = dp[i+1] if c != 0 && can't form a pair
    // dp[i] = dp[i+1] + dp[i+2] if c!=0 && can form a pair
    // Time Complexity O(N) 1ms 93.51%
    // Space Complexity O(1) 40.8MB 59.3%
    public int numDecodings(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (arr[i] == '1' || arr[i] == '2' && arr[i + 1] < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
