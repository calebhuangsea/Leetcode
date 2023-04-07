package H154FindMinimumInRotatedSortedArrayII;

public class Solution {
    /**
     * Make sure the right index is either minimum or the right side of the minimum
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.8MB 19.43%
     */
    public int findMin(int[] nums) {
        int lo = -1;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] < nums[hi]) {
                hi = m;
            } else if (nums[m] > nums[hi]) {
                lo = m;
            } else {
                hi--;
            }
        }
        return nums[hi];
    }
}
