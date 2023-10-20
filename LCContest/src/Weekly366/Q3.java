package Weekly366;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q = new Q3();
    }


    class Solution {
        /**
         * Time: O(N^2)
         * Space: O(N^2)
         */
        char[] c1;
        char[] c2;
        int[][][] memo;
        int x;
        public int minOperations(String s1, String s2, int x) {
            c1 = s1.toCharArray();
            c2 = s2.toCharArray();
            this.x = x;
            int count = 0;
            for (int i = 0; i < c1.length; i++) {
                count ^= c1[i];
                count ^= c2[i];
            }
            if (count != 0) {
                return -1;
            }
            int n = c1.length;
            memo = new int[n][n + 1][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(0, n - 1, 0);
        }

        private int dfs(int pre, int i, int j) {
            if (i < 0) {
                return (j > 0 || pre > 0) ? Integer.MAX_VALUE / 2 : 0;
            }
            if (memo[i][j][pre] != -1) {
                return memo[i][j][pre];
            }
            // if we do nothing not need to flip, or we do need to flip but different
            if ((c1[i] == c2[i]) == (pre == 0)) {
                return dfs(0, i - 1, j);
            }
            int min = dfs(1, i -1 ,j) + 1;
            min = Math.min(min, dfs(0, i - 1 ,j + 1) + x);
            if (j > 0) {
                min = Math.min(min, dfs(0, i -1 ,j - 1));
            }
            memo[i][j][pre] = min;
            return min;
        }
    }



}
