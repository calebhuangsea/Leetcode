package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        // pre[i]: longest decresing starting from i to the right
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    right[i] = Math.max(right[i], 1 + right[j]);
                }
            }
        }
        // suf[i]: longest decreasing starting from i to the left
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    left[i] = Math.max(left[i], 1 + left[j]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, left[i] + right[i] - 1);
        }
        System.out.println(n - max);
    }
}
