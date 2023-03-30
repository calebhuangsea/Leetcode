package H87ScrambleString;

public class Solution {
    /**
     * Time Complexity O(n^4) 14ms 42.91%
     * Space Complexity O(n^3) 42.5MB 84.62%
     */
    public boolean isScramble(String s1, String s2) {
        // dp[length][i][j], whether s1 start from i and s2 start from j with length is scrambled
        int n = s1.length();
        boolean dp[][][] = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        dp[length][i][j] |= dp[newLength][i][j] && dp[length - newLength][i + newLength][j + newLength];// no swap
                        dp[length][i][j] |= dp[newLength][i][j + length - newLength] && dp[length - newLength][i + newLength][j];//swap
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}
