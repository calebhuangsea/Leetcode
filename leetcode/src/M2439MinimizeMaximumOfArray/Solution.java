package M2439MinimizeMaximumOfArray;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity
     */
    public int minimizeArrayValue(int[] nums) {
        long prefix = nums[0];
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix += nums[i];
            max = Math.max(max, (prefix + i) / (i + 1));
        }
        return (int)max;
    }
}
