package M1143LongestCommonSubsequence;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    private char[] s1, s2;
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        memo = new int[s1.length][s2.length];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(s1.length - 1, s2.length - 1);
    }

    private int dp(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] == -1) {
            if (s1[i] == s2[j]) {
                memo[i][j] = 1 + dp(i - 1, j - 1);
            } else {
                memo[i][j] = Math.max(dp(i - 1, j), dp(i, j - 1));
            }

        }
        return memo[i][j];
    }
}
