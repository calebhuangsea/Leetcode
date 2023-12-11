package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ91 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //   - -
        //. | | |
        //.  - -
        //. | | |
        //.  - -
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            // dp[i][j]: how many ways to reach i, j
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <=n; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j <= m; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
