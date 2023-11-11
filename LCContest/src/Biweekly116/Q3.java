package Biweekly116;

import java.util.*;

public class Q3 {
    /**
     * Time: O(NT)
     * Space: O(NT)
     * @param nums
     * @param target
     * @return
     */
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for (int[] r : dp) Arrays.fill(r, -1);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < target+1; j++) {
                // if we use don't take
                dp[i][j] = dp[i-1][j];
                // if we
                if (j >= nums.get(i-1) && dp[i-1][j - nums.get(i-1)] != -1) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j - nums.get(i-1)]);
                }
            }
        }
        return dp[n][target];
    }
}
