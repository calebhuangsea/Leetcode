package M325MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Prefix Sum and hashtable
     * Time Complexity O(N) 75ms 71.66%
     * Space Complexity O(N) 81.5MB 22.2%
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int prefix = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (prefix == k) {
                len = i + 1;
            }
            // -2 -3 -1 1
            // if prefix - previous subarray = k
            if (map.containsKey(prefix - k)) {
                len = Math.max(len, i - map.get(prefix - k));
            }
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }
        return len;
    }
}
