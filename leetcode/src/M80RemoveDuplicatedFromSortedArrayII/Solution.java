package M80RemoveDuplicatedFromSortedArrayII;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.7MB 57.74%
     */
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
