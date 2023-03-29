package H1402ReducingDishes;

import java.util.Arrays;

public class Solution {
    /**
     * Greedy with prefix sum for sorted array
     * Time Complexity O(Nlog(N)) 1ms 100%
     * Space Complexity O(1) 40.6MB 73.2%
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefix = 0;
        int max = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            prefix += satisfaction[i];
            if (prefix <= 0) {
                return max;
            }
            max += prefix;
        }
        return max;
    }

    // dp[i] time start from i
    // Time Complexity O(Nlog(N)) 4ms 40.98%
    // Space Complexity O(N) 41.2MB 46.39%
//    public int maxSatisfaction(int[] satisfaction) {
//        Arrays.sort(satisfaction);
//        int[] dp = new int[satisfaction.length];
//        int max = 0;
//        for (int i = 0; i < dp.length; i++) {
//            int day = 1;
//            for (int j = i; j < dp.length; j++) {
//                dp[i] += satisfaction[j] * day++;
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }
}
