package H727MinimumWindowSubsequence;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    public String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return "";
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[0]) {
                dp[0][i] = i;
            } else {
                dp[0][i] = -1;
            }
        }
        for (int i = 1; i < m; i++) {
            char c2 = s2.charAt(i);
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    dp[i][j] = -1;
                } else {
                    char c1 = s1.charAt(j);
                    if (c1 != c2) {
                        dp[i][j] = -1;
                    } else {
                        for (int z = j - 1; z >= 0; z--) {
                            if (dp[i-1][z] != -1) {
                                dp[i][j] = dp[i-1][z];
                                break;
                            } else {
                                dp[i][j] = -1;
                            }
                        }
                    }
                }
            }
        }
        int left = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] != -1) {
                int dis = i - dp[m - 1][i] + 1;
                if (min > dis) {
                    left = dp[m - 1][i];
                    min = dis;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return s1.substring(left, min + left);
    }
}
