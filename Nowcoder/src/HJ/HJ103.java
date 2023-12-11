package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(max);
    }
}
