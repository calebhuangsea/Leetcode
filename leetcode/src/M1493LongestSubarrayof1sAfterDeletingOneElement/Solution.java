package M1493LongestSubarrayof1sAfterDeletingOneElement;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int longestSubarray(int[] nums) {
        // longest subarray containing only 1 zero
        int max = 0;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[left++] == 0) {
                    count--;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
