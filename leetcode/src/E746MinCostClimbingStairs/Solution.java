package E746MinCostClimbingStairs;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n1 = 0;
        int n2 = 0;
        int n3;
        for (int i = 2; i <= cost.length; i++) {
            n3 = Math.min(cost[i - 1] + n2, cost[i - 2] + n1);
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
