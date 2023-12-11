package Meituan;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int max = min;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            if (num < min || num > max) count++;
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        System.out.println(count);
    }
}
