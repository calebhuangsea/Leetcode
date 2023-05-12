package EDUC.R148;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int l = 0; l < lines; l++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            long[] pre = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            Arrays.sort(arr);
            pre[0] = arr[0];
            for (int i = 1; i < n; i++) {
                pre[i] = arr[i] + pre[i - 1];
            }
            long min = sum;
            for (int i = 0; i <= k; i++) {
                // i is how many min operation we do
                // i * 2 - 1;
                long max = sum - pre[n - k - 1 + i];
                if (i == 0) {
                    min = Math.min(min, max);
                    continue;
                }
                max += pre[i * 2 - 1];
                min = Math.min(min, max);
            }
            System.out.println(sum - min);
        }
    }
}
