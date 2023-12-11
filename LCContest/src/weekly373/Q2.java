package weekly373;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    /**
     * We can use a dp array to store previous substring status and count one by one
     * dp[i][j][0]: number of vowels from i to j
     * dp[i][j][1]: number of constants from i to j
     * Runtime: O(N^2)
     * Space: O(N^2)
     */

    public int beautifulSubstrings(String s, int k) {
        int count = 0;
        char[] ss = s.toCharArray();
        // dp[i][j][0]: vowels from i to j
        // dp[i][j][1]: constants from i to j
        int[][][] dp = new int[ss.length][ss.length][2];
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < ss.length; i++) {
            if (vowels.contains(ss[i])) {
                dp[i][i][0]++;
            } else {
                dp[i][i][1]++;
            }
        }
        for (int i = 0; i < ss.length - 2; i++) {
            for (int j = i + 2; j < ss.length; j+=2) {
                // dp[i][j][0]
                dp[i][j][0] = dp[i][j - 1][0];
                dp[i][j][1] = dp[i][j - 1][1];
                if (vowels.contains(ss[j])) {
                    dp[i][j][0]++;
                } else {
                    dp[i][j][1]++;
                }
                if (dp[i][j][0] == dp[i][j][1] && (dp[i][j][0] * dp[i][j][1] % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

}
