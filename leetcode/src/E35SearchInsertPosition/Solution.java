package E35SearchInsertPosition;

public class Solution {
    /**
     *  Binary Search
     *  Time Complexity O(log(N)) 0ms 100%
     *  Space Complexity O(1) 42.6MB 9.5%
     */
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int lo = 0;
        int hi = nums.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                while (nums[mid--] == target)
                    return mid + 1;
            } else if (nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
