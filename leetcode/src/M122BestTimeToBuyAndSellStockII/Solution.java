package M122BestTimeToBuyAndSellStockII;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.4MB 52.16%
     */
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int empty = 0;
        for (int n : prices) {
            int empty2 = Math.max(empty, hold + n);
            hold = Math.max(hold, empty - n);
            empty = empty2;
        }
        return empty;
    }
}
