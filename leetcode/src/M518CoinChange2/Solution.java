package M518CoinChange2;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(N * Amount)
     * Space: O(N * Amount)
     */
    private int[][] memo;
    private int[] coins;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        this.coins = coins;
        return dp(0, amount);
    }

    // dp(i): How many ways to pay for i amount
    private int dp(int i, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }

        memo[i][amount] = dp(i + 1, amount);
        if (coins[i] <= amount) {
            memo[i][amount] += dp(i, amount - coins[i]);
        }
        return memo[i][amount];
    }
}
