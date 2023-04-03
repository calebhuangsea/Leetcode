package M55JumpGame;

public class Solution {
    /**
     * DP
     * Time Complexity: O(N^2) 30ms 26.22%
     * Space Complexity: O(N) 43.4MB 16.15%
     */
//    public boolean canJump(int[] nums) {
//        boolean[] dp = new boolean[nums.length];
//        int r = nums[0];
//        for (int i = 0; i < nums.length && i <= nums[0]; i++) {
//            dp[i] = true;
//        }
//        for (int i = 1; i < nums.length; i++) {
//            if (!dp[i]) {
//                return false;
//            }
//            for (int j = r; j < nums.length && j <= nums[i] + i; j++) {
//                dp[j] = true;
//            }
//            r = nums[i] + i;
//        }
//        return true;
//    }

    /**
     * Greedy from the end of the array, see if we can reach the start
     * Time Complexity: O(N) 1ms 99.98%
     * Space Complexity: O(1) 42.9MB 65.13%
     */
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
