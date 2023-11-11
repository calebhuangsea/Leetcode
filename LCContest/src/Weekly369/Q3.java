package Weekly369;

import java.util.Arrays;

public class Q3 {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param nums
     * @param k
     * @return
     */
    public long minIncrementOperations(int[] nums, int k) {
        long dp1 = 0, dp2 = 0, dp3 = 0, dp = 0;
        for (int i = 0; i < nums.length; i++) {
            dp = Math.min(dp1, Math.min(dp2, dp3)) + Math.max(k - nums[i], 0);
            dp3 = dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return Math.min(dp1, Math.min(dp2, dp3));
    }
    // dp(i) how many times if I increase dp(i)
//    public long minIncrementOperations(int[] nums, int k) {
//        long[] dp = new long[nums.length];
//        Arrays.fill(dp, -1);
//        long res = Long.MAX_VALUE;
//        res = Math.min(res, dfs(dp, nums, nums.length - 1,k));
//        res = Math.min(res, dfs(dp, nums, nums.length - 2,k));
//        res = Math.min(res, dfs(dp, nums, nums.length - 3,k));
//        return res;
//    }
//
//    private long dfs(long[] dp, int[] nums, int index, int k) {
//        if (index < 0) return 0;
//        if (dp[index] != -1) return dp[index];
//        // we must increase index i
//        long sum = k - nums[index];
//        sum = Math.max(0, sum);
//        long min = Long.MAX_VALUE;
//        for (int i = 1; i <= 3; i++) {
//            min = Math.min(min, dfs(dp, nums, index - i, k));
//        }
//        sum += min == Integer.MAX_VALUE ? 0 : min;
//        return dp[index] = sum;
//    }
}
