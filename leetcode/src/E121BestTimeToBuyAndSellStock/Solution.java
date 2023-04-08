package E121BestTimeToBuyAndSellStock;

public class Solution {
    /**
     * Time Complexity O(N) 2ms 84.77%
     * Space Complexity O(1) 59.2MB 43.53%
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
            if (prices[i] < buy) {
                buy = prices[i];
            }
        }
        return profit;
    }
}
