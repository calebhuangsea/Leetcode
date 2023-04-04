package M611ValidTriangleNumber;

import java.util.Arrays;

public class Solution {
    /**
     * Time Complexity O(N^2) 37ms 55.39%
     * Space Complexity O(1) 42.5MB 27.79%
     */
//    public int triangleNumber(int[] nums) {
//        int count = 0;
//        int n = nums.length;
//        Arrays.sort(nums);
//        int lo = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                lo = i + 1;
//            }
//        }
//        for (int i = n - 1; i >= 2; i--) {
//            // Only need to consider when left two lengths are greater than nums,
//            // other conditions are automatically satisfied
//            int l = lo;
//            int r = i - 1;
//            while (l < r) {
//                if (nums[r] + nums[l] > nums[i]) {
//                    count += r - l;
//                    r--;
//                } else {
//                    l++;
//                }
//            }
//        }
//        return count;
//    }

    /**
     * Time Complexity O(N^2log(N)) 222ms 27.3%
     * Space Complexity O(1) 42.1MB 63.8%
     */
    public int triangleNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            // if current + (last - 1) <= last
            if (nums[i] == 0) {
                continue;
            }
            // Only need to consider when left two lengths are greater than nums,
            // other conditions are automatically satisfied
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                k = binarySearch(nums, k, n - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    // find right most insert point of left most
    int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
