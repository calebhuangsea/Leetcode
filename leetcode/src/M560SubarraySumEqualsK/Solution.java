package M560SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Prefix sum and hashtable
     * Time Complexity O(N) 27ms 45.95%
     * Space Complexity O(N) 47.3MB 18.94%
     */
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            prefix += n;
            if (prefix == k) {
                count++;
            }
            // prefix - k = subarray
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
