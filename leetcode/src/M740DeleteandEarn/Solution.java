package M740DeleteandEarn;

import java.util.Map;
import java.util.HashMap;
public class Solution {
    /**
     * Time: O(N + W)
     * Space: O(N)
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for (int n : nums) {
            points.put(n, points.getOrDefault(n, 0) + n);
            maxNumber = Math.max(maxNumber, n);
        }
        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);
        for (int i = 2; i <= maxNumber; i++) {
            int gain = points.getOrDefault(i, 0);
            int temp = Math.max(twoBack + gain, oneBack);
            twoBack = oneBack;
            oneBack = temp;
        }
        return Math.max(oneBack, twoBack);
    }
}
