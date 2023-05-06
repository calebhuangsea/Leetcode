package M1498NumberofSubsequencesThatSatisfytheGivenSumCondition;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(nlogn)
     * Space: O(N)
     * @param nums
     * @param target
     * @return
     */
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int mod = 1000000007;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        for (int i = 0; i < n; i++) {
            // check every number
            int index = binarySearch(nums, target - nums[i]) - 1;
            if (index < i) {
                break;
            }
            res += power[index - i];
            res %= mod;
        }
        return res % mod;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;

    }
}
