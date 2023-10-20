package Other.R900;

import java.util.Scanner;

public class I1879BChipsOnTheBoard {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            long sumA = 0;
            long sumB = 0;
            long minA = Integer.MAX_VALUE;
            long minB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sumA += a[i];
                minA = Math.min(minA, a[i]);
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                sumB += b[i];
                minB = Math.min(minB, b[i]);
            }
            System.out.println(Math.min(sumA + n * minB, sumB + n * minA));
        }
    }
}
