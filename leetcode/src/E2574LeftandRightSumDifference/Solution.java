package E2574LeftandRightSumDifference;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public int[] leftRigthDifference(int[] nums) {
        int right = 0;
        int left = 0;
        for (int n : nums) {
            right += n;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            right -= val;
            nums[i] = Math.abs(left - right);
            left += val;
        }
        return nums;
    }
}
