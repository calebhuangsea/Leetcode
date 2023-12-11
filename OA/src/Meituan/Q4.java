package Meituan;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int last = 1;
        int diff = 1;
        System.out.print(last + " ");
        for (int i = 1; i < n; i++) {
            // a[i] (last + diff), 还有n - 1 - i个数，所以last + diff + (n - 1 - i) <= m;
            if (last + diff + (n - 1- i) <= m) {
                last += diff++;
            } else {
                last += 1;
            }
            System.out.print(last + " ");
        }

    }
}
