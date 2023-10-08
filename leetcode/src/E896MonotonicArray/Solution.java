package E896MonotonicArray;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean isMonotonic(int[] nums) {
        boolean increase = true;
        boolean decrease = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                decrease = false;
            }
            if (nums[i] > nums[i + 1]) {
                increase = false;
            }
        }
        return increase || decrease;
    }
}
