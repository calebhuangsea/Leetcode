package JD;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), k = in.nextInt();
        String s = in.next();
        int count = 0;
        // 0 1 2 3 4
        for (int i = 0; i <= n - k; i++) {
            // System.out.println(i + " : " + (i + k - 1));
            count += check(s, i, i + k - 1);
            // System.out.println(count);
        }
        System.out.println(count);
    }

    private static int check(String s, int l, int r) {
        while (l < r) {
            // System.out.println("n: " + l + " : " + r);
            if (s.charAt(l++) != s.charAt(r--)) return 0;
        }
        return 1;
    }
}
