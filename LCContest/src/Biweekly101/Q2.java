package Biweekly101;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(maximumCostSubstring("adaa", "d", new int[] {-1000}));
    }
    static int max = 0;
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        int max = 0;
        int[] values = new int[26];
        for (int i = 0; i < 26; i++) {
            values[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            values[chars.charAt(i) - 'a'] = vals[i];
        }
        char[] arr = s.toCharArray();
        // OPT(i) max value from i
        int[] dp = new int[arr.length];
        dp[0] = values[arr[0] - 'a'];
        max = Math.max(dp[0], max);
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            dp[i] += values[arr[i] - 'a'];
            max = Math.max(dp[i], max);
        }
        return max;
    }


}
