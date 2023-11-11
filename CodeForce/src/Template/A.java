package Template;

public class A {
        public static int maximizeValue(int[] a, int[] b, int T) {
            int n = a.length; // Number of elements in the arrays
            int[][] dp = new int[n + 1][T + 1]; // Initialize a 2D DP table

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= T; j++) {
                    if (a[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i - 1]] + b[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n][T];
        }

        public static void main(String[] args) {
            int[] a = {2, 3, 1, 4};
            int[] b = {5, 6, 3, 9};
            int T = 7;
            int result = maximizeValue(a, b, T);
            System.out.println(result); // Output: 17
        }

}
