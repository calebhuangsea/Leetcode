package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ79 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int p = (int) Math.pow(n, 3) / n;
        int init;
        if (n % 2 == 0) {
            init = p - n + 1;
        } else {
            init = p - n / 2 * 2;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(init);
            init+=2;
            if (i != n - 1) {
                System.out.print('+');
            }
        }
    }
}
