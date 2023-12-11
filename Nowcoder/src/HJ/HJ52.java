package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String a = in.nextLine();
            int n = a.length();
            String b = in.nextLine();
            int m = b.length();
            // dp[i][j] = minimum operation to make a[0, i] equals b[0, j]
            int[][] dp = new int[n + 1][m + 1];
            for (int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
            dp[0][0] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i < m; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // calculate dp[i][j]? what are the combinations?
                    // dp[i - 1][j - 1] + ?
                    if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i-1][j-1], dp[i - 1][j])) + 1;
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
