package M75SortColors;

/**
 * Sort an array containing three type of integers in order
 */
class Solution {
    /**
     * Time Complexity: O(n) 0ms 100%
     * Space Complexity: O(1) 41.4MB 15.58%
     * Use two index, one for 0 one for 2
     * Use one pass for loop, keep going if we find an 0(swap) or 1
     * remain at the same place if we find a 2 because case [1, 2, 0]
     * after we swap 2, we might fail to examine smaller value like 0
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                swap(nums, i++, k);
            } else if (nums[k] == 2) {
                swap(nums, j--, k--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}