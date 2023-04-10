package M2598SmallestMissingNon_negativeIntegerAfterOperations;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity (N)
     */
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int v = (n % value + value) % value;
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        int i = 0;
        while (true) {
            int v = i % value;
            if (map.containsKey(v)) {
                map.put(v, map.get(v) - 1);
                if (map.get(v) == 0) {
                    map.remove(v);
                }
            } else {
                return i;
            }
            i++;
        }
    }
}
