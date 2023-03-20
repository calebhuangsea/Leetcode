package E1TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Use hashtable to keep track of satisfy number : index
     * Time Complexity: O(N) 1ms 99.31% Only one iteration
     * Space Complexity: O(N) 42.6MB 60.35% can store every number if there is no answer
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            // map doesn't contain key
            map.put(target - nums[i], i);
        }
        return null;
    }
}
