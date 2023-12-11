package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Hj83 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt(), n = in.nextInt();
            if (m >= 0 && m <= 9 && n >= 0 && n <= 9) {
                System.out.println(0);
            } else {
                m = 0;
                n = 0;
                System.out.println(-1);
            }
            // swap
            int x1 = in.nextInt(), y1 = in.nextInt();
            int x2 = in.nextInt(), y2 = in.nextInt();
            if (x1 >= 0 && x1 < m && x2 >= 0 && x2 < m && y1 >= 0 && y1 < n && y2 >= 0 && y2 < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            int x = in.nextInt();
            if (m == 9 || x < 0 || x >= m) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            int y = in.nextInt();
            if (n == 9 || y < 0 || y >= n) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            x = in.nextInt();
            y = in.nextInt();
            if (x >= 0 && x < m && y >= 0 && y < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
