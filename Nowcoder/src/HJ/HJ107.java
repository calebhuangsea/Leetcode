package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        double num = in.nextDouble();
        double l = Math.min(-1, num);
        double r = Math.max(1, num);
        while (r - l > 0.001) {
            double m = l + (r - l) / 2;
            if (m * m * m < num) {
                l = m;
            } else if (m * m * m > num) {
                r = m;
            } else {
                System.out.printf("%.1f", m);
                break;
            }
        }
        System.out.printf("%.1f", r);
    }
}
