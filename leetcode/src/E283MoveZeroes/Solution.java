package E283MoveZeroes;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 44.4MB 10.59%
     */
    public void moveZeroes(int[] nums) {
        int insert = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insert];
                nums[insert++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
