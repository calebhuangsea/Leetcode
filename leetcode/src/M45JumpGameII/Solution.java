package M45JumpGameII;

public class Solution {
    /**
     * DP
     * Time Complexity O(N^2) 86ms 13.97%
     * Space Complexity O(N ) 43MB 36.87%
     */
    public int jump(int[] nums) {
        // dp[i] = min steps to reach this position
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j + i < nums.length && j <= nums[i]; j++) {
                if (dp[j + i] == 0) {
                    dp[j + i] = 1 + dp[i];
                    continue;
                }
                // update positions we can reach from current position
                dp[j + i] = Math.min(1 + dp[i], dp[j + i]);
            }
        }
        return dp[nums.length - 1];
    }
}
