package E905SortArrayByParity;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 1,0 swap
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            // 0, 1 stay
            // 1, 1
            // 0, 0
            if (nums[i] % 2 == 0) {
                i++;
            }
            if (nums[j] % 2 == 1) {
                j--;
            }
        }
        return nums;
    }
}
