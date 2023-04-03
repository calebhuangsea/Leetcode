package M1004MaxConsecutiveOnesIII;

public class Solution {
    /**
     * Same direction two pointers
     * Time Complexity O(N) 2ms 99.94%
     * Space Complexity O(1) 44.2MB 32.77%
     */
    public int longestOnes(int[] nums, int k) {
        if (k == nums.length) {
            return k;
        }
        int count = 0;
        int l = 0;
        int r;
        for (r = 0; r < nums.length; r++) {
            // contract
            if (nums[r] == 0) {
                count++;
            }
            if (count > k) {
                count += nums[l++] - 1;
            }
        }
        return r - l;
    }
}
