package M153FindMinimuminRotatedSortedArray;

public class Solution {
    /**
     * Time Complexity O(log(N)) 0ms 100%
     * Space Complexity O(1) 42.6MB 10.67%
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            int mid = nums[m];
            // check if the left is greater
            boolean smallest = m == 0 ? mid < nums[nums.length - 1] : mid < nums[m - 1];
            if (smallest) {
                return nums[m];
            } else if (mid > nums[nums.length - 1]) {
                // cut the left side
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return -1;
    }
}
