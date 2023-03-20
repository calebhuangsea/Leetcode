package M71SearchInRotatedSortedArrayII;

public class Solution {

    /**
     * Condition binary search
     * We search for target at lo, mid, hi because it is not distinct number
     * We update the lo or hi index for case that we are sure about
     * and only move lo and hi for other uncertainty cases(when there are duplicates)
     * Time Complexity: O(Nlog(N)) 0ms 100%
     * Space Complexity: O(1) 42.5MB 31.51%
     */
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == target || nums[mid] == target || nums[hi] == target) {
                return true;
            } else if (nums[mid] >= nums[lo]) {
                if (target < nums[mid] && target > nums[lo]) {
                    hi = mid - 1;
                    continue;
                }
            } else {
                if (target < nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                    continue;
                }
            }
            lo++;
            hi--;
        }
        return false;
    }
}
