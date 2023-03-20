package M53MaximumSubarray;

class Solution {
    /**
     * Greedy approach like dynamic programming
     * We have a current subarray sum, for every element we examine
     * keep curr + nums[i] or nums[i], update max as well
     * Time Complexity O(N) 1ms 100%
     * Space Complexity O(1) 51.3MB 92.77%
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // max subarray sum
        int curr = nums[0]; // current subarray sum
        for (int i = 1; i < nums.length; i++) {
            // you don't need subarray if they added up smaller than only the new one
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
