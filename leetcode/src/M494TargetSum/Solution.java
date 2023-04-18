package M494TargetSum;

public class Solution {
    /**
     * Time: O(2^N)
     * Space: O(n)
     */
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return sum;
    }

    private void dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                sum++;
            }
            return;
        }
        dfs(nums, index + 1, target - nums[index]);
        dfs(nums, index + 1, target + nums[index]);
    }
}
