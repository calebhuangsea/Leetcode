package E704BinarySearch;

/**
 * Just Binary Search
 */
public class Solution {

    /**
     * Binary Search
     * Time Complexity: O(Nlog(N)) 0ms 100%
     * Space Complexity: O(1) 43.3MB 26.3%
     */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return -1;
    }
}
