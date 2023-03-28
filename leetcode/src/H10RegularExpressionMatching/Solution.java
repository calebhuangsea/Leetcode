package H10RegularExpressionMatching;

/**
 * DP
 * Time Complexity O(MN) 0ms 100%
 * Space Complexity O(MN) 42.7MB 18.3%
 */
public class Solution {
    // OPT(i, j): check if the string starting from index i match the expression from index j
    // if j + 1 < p.length() && :
    public boolean isMatch(String s, String p) {
        return helper(0, 0, s.toCharArray(), p.toCharArray(), new Boolean[s.length()][p.length()]);
    }

    private boolean helper(int i, int j, char[] s, char[] p, Boolean[][] dp) {
        // ending condition
        if (i >= s.length || j >= p.length) {
            if (i >= s.length && j >= p.length) {
                // both string and pattern are finished
                return true;
            } else if (j + 1 < p.length && p[j + 1] == '*') {
                return helper(i, j + 2, s, p, dp);
            }
            // else it would be pattern out and string not finish, false
            return false;
        }
        if (dp[i][j] != null) {
            // if we have checked this possibility
            return dp[i][j];
        }
        // if * is possible
        if (j + 1 < p.length && p[j + 1] == '*') {
            // if it is .*
            if (p[j] == '.') {
                return dp[i][j] = helper(i, j + 2, s, p, dp) || helper(i + 1, j, s, p, dp);
            } else {
                // if it is letter*
                // check if letter match
                if (p[j] == s[i]) {
                    return dp[i][j] = helper(i + 1, j, s, p, dp) || helper(i, j + 2, s, p, dp);
                } else {
                    return dp[i][j] = helper(i, j + 2, s, p, dp);
                }
            }
        } else if (s[i] == p[j] || p[j] == '.') {
            return dp[i][j] = helper(i + 1, j + 1, s, p, dp);
        }
        return false;
    }
}
