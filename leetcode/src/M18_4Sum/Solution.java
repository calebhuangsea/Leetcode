package M18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * One more loop for 3 sum two pointers (Be careful of long integer)
     * Time Complexity O(N^3) 5ms 90.82%
     * Space Complexity O(1) 42.6MB 86.46%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // We check repetitive for every index, same way for first two and same way for last two
            int x1 = nums[i];
            if (i > 0 && x1 == nums[i - 1]) {
                continue; // avoid repetitive answer
            }
            if (0l + x1 + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                // if current smallest sum is greater than 0, then no more
                break;
            }
            if (0l + x1 + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                // if the maximum sum from i is smaller than 0, escape to a larget sequence
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                int x2 = nums[j];
                if (j > i + 1 && nums[j - 1] == x2) {
                    continue; // avoid repetitive answer
                }
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = 0l + x1 + x2 + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(List.of(x1, x2, nums[l], nums[r]));
                        for (++l; l < r && nums[l] == nums[l - 1]; l++);
                        for (--r; l < r && nums[r] == nums[r + 1]; r--);
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
