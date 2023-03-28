package E26RemoveDuplicatesFromSortedArray;

public class Solution {
    /**
     * Time Complexity O(N) 1ms 99.97%
     * Space Complexity O(1) 44.5MB 14.34%
     */
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
