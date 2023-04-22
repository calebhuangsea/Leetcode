package src.H1312MinimumInsertionStepstoMakeaStringPalindrome;

public class Solution {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int minInsertions(String s) {
        int n = s.length();
        // dp[i][j] = max length of common subsequence between first i in s1 and first j in s2
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = s.charAt(i) == s.charAt(n - 1 - j) ? 1 + dp[i][j] : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return n - dp[n][n];
    }
}
