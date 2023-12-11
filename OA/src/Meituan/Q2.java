package Meituan;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
        long[] pre = new long[n];
        pre[0] = 0;
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + arr[i - 1];
        long[] suf = new long[n];
        suf[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) suf[i] = suf[i + 1] + arr[i + 1];
        Long ans = null;
        for (int i = 1; i < n; i++) {
            if (pre[i] >= arr[i]) {
                if (ans == null) ans = pre[i] + suf[i] - arr[i];
                else ans = Math.min(ans, pre[i] + suf[i] - arr[i]);
            }
        }
        System.out.println(ans);
    }
}
