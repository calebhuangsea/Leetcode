package E724FindPivotIndex;

public class Solution {
    /**
     * Prefix sum
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int n : nums) {sum += n;}
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {return i;}
            leftSum += nums[i];
        }
        return -1;
    }
}
