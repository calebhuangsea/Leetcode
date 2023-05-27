package M1140StoneGameII;

public class Solution {
    /**
     * Time: O(N^3)
     * Space: O(N^2)
     */
    public int stoneGameII(int[] piles) {
        // what does it mean to play optimally?
        // If both players play optimally, that means there are only two possible outcomes
        // We just need to compare two outcomes and return the larger one
        // n * n * 2 dp
        int n = piles.length;
        int[][][] dp = new int[2][n + 1][n + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return f(piles, dp, 0, 0, 1);

    }

    private int f(int[] piles, int[][][] dp, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[p][i][m] != -1) {
            return dp[p][i][m];
        }
        int res = p == 1 ? 1000000:-1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, dp, 1, i + x, Math.max(x, m)));
            } else {
                res = Math.min(res, f(piles, dp, 0, i + x, Math.max(x, m)));
            }
        }
        return dp[p][i][m] = res;
    }
}
