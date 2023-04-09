package Weekly340;
import java.util.*;
public class Q2 {
    /**
     * Prefix and suffix sum
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public long[] distance(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        long[] res = new long[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                // calculate prefix sum
                int prev = map.get(nums[i]);
                count[i] = count[prev] + 1;
                res[i] = res[prev] + count[prev] * (i - prev);
            } else {
                count[i] = 1;
            }
            map.put(nums[i], i);
        }
        count = new int[n];
        map = new HashMap<>();
        long[] reverse = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                // calculate prefix sum
                int prev = map.get(nums[i]);
                count[i] = count[prev] + 1;
                reverse[i] = reverse[prev] + count[prev] * (prev - i);
            } else {
                count[i] = 1;
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            res[i] += reverse[i];
        }
        return res;
    }
}
