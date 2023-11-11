package M413ArithmeticSlices;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == diff) count++;
                else break;
            }
        }
        return count;
    }
}
