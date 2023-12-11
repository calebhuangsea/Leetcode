package Other.R1500;

import java.util.Scanner;

public class I1236BAliceandtheListofPresents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long mod = (long)(1e9 + 7);
        //(2^m - 1)^n
        long base = pow(2, m, mod) - 1;
        System.out.println(pow(base, n, mod));

    }

    static long pow(long base, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            n /= 2;
        }
        return res % mod;
    }
}
