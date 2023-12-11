package Meituan;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        int max = 0;
        for (long num : a) {
            long i = 1;
            int count = 0;
            while (num % i == 0) {
                count++;
                i *= 2;
            }
            max = Math.max(count-1, max);
        }
        System.out.println(max);


    }
}
