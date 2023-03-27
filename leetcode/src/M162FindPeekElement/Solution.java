package M162FindPeekElement;

public class Solution {
    /**
     * Binary Search with condition
     * Time Complexity: O(log(N)) 0ms 100%
     * Space Complexity: O(1) 42.1MB 43.15
     */
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean prev = mid == 0 ? true : nums[mid] > nums[mid - 1];
            boolean next = mid == nums.length - 1 ? true : nums[mid] > nums[mid + 1];
            if (prev && next) {
                return mid;
            } else if (mid == 0) {
                lo = mid + 1;
            } else if (mid == nums.length - 1) {
                hi = mid - 1;
            } else if (nums[mid] < nums[mid - 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
