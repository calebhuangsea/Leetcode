package M33SearchInRotatedSortedArray;

/**
 * Search a value in a rotated array
 */
public class Solution {

    /**
     * Binary Search with extra lo and hi check
     * Time Complexity: O(Nlog(N)) 0ms 100%
     * Space Complxity: O(1) 41.8MB 71.56%
     */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[lo]) {// this means there is a cut at the left
                if (target <= nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {// this means there is a cut at the right
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
