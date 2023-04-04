package M16_3SumClosest;

import java.util.Arrays;

public class Solution {
    /**
     * Two pointers
     * Time Complexity O(N^2) 13ms 90.7%
     * Space Complexity O(1) 42MB 61.82%
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = 50000;
        int n = nums.length;
        for (int i = 0; i < n && diff != 0; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return target - diff;
    }
}
