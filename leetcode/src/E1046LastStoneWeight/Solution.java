package E1046LastStoneWeight;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(N^2 * log(N))
     * Space: O(1)
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int n = stones.length;
        while (stones[n - 2] != 0) {
            stones[n - 1] = stones[n - 1] - stones[n - 2];
            stones[n - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[n - 1];
    }
}
