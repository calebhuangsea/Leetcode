package H1416RestoreTheArray;

public class Solution {
    /**
     * Time: O(m * log(k))
     * Space: O(N + 1)
     */
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        int count = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (Long.parseLong(sub) > k) {
                    break;
                }
                dp[j + 1] = (dp[j + 1] + dp[i]) % mod;
            }
        }
        return dp[n] % mod;
    }
}
