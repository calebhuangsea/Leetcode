package M1658MinimumOperationsToReduceXToZero;

public class Solution {
    /**
     * Since we are looking for min length from both side, we can convert that into looking for a subarray in the middle
     * Time Complexity O(N) 5ms 82.72%
     * Space Complexity O(1) 52.2MB 41.36%
     */
    public int minOperations(int[] nums, int x) {
        int sum = -x;
        for (int n : nums) {
            sum += n;
        }
        // sum: we need to remove this amount from the array
        if (sum < 0) {
            return -1;
        }
        int l = 0;
        int max = -1;
        int curr = 0;
        for (int r = 0; r < nums.length; r++) {
            curr += nums[r];
            while (curr > sum) {
                curr -= nums[l++];
            }
            if (curr == sum) {
                max = Math.max(r - l + 1, max);
            }
        }

        return max < 0 ? -1 : nums.length - max;
    }
}
