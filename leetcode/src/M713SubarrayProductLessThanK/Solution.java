package M713SubarrayProductLessThanK;

public class Solution {
    /**
     * Sliding window
     * Time Complexity O(N) 6ms 96.82%
     * Space Complexity O(1) 50.5MB 15.2%
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int l = 0;
        int sum = 0;
        int curr = 1;
        for (int r = 0; r < nums.length; r++) {
            curr *= nums[r];
            while (curr >= k) {
                curr /= nums[l++];
            }
            sum += r - l + 1;
        }
        return sum;
    }
}
