package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long sum = 0;
            // there are n * 2 base
            // 0, 1 .... n - 1 * 3
            System.out.print((2 + 3 * n - 1) * n / 2);
        }
    }
}
