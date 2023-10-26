package M2411SmallestSubarrayWithMaximumBitwiseOR;

public class Solution {
    /**
     * Time: O(30n)
     * Space: O(30 + n)
     */
    public int[] smallestSubarrays(int[] nums) {
        int curr = 0;
        int[] res = new int[nums.length];
        int[] last = new int[30]; // last[j] means last time we see 2^j
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = 1;
            for (int j = 0; j < 30; j++) {
                if (((nums[i]) & (1 << j)) != 0) {
                    last[j] = i;
                }
                res[i] = Math.max(res[i], last[j] - i + 1);
            }
        }
        return res;
    }
}
