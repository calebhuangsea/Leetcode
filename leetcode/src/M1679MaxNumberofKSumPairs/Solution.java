package M1679MaxNumberofKSumPairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            int freq = map.getOrDefault(n, 0);
            if (freq > 0) {
                // that means there is a match
                map.put(n, freq - 1);
                count++;
            } else {
                // no match
                map.put(k - n, map.getOrDefault(k - n, 0) + 1);
            }
        }
        return count;
    }

    /**
     * Sort and Two Pointers
     * Time: O(Nlog(N))
     * Space: O(1)
     */
    public int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right--] >= k);
        right++;
        int left = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                count++;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
