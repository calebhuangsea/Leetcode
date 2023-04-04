package M15_3Sum;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(N^2) 37ms 82.86%
     * Space Complexity O(1) 50.1MB 45.19%
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (x + nums[n - 1] + nums[n - 2] < 0) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(List.of(x, nums[l], nums[r]));
                    for (++l; l < r && nums[l] == nums[l - 1]; l++);
                    for (--r; l < r && nums[r] == nums[r + 1]; r--);
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
