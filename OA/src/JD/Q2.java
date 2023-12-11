package JD;

import java.util.Scanner;

public class Q2 {
    // 小红的矩阵
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
        // 1 22 33 444 55 6666 88 9 1010 12121212
    }
}
