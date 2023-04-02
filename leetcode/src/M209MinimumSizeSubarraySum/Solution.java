package M209MinimumSizeSubarraySum;

public class Solution {
    /**
     * Sliding windows
     * Time Complexity O(N) 1ms 100%
     * Space Complexity O(1) 49.9MB 78.45%
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int curr = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            // contract left
            while (curr >= target) {
                min = Math.min(min, i - l + 1);
                curr -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
