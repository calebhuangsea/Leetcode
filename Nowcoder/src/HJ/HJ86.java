package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int max = 0;
            int count = 0;
            while (a > 0) {
                if ((a & 1) == 1) {
                    count++;
                    max =Math.max(max, count);
                } else {
                    count = 0;
                }
                a >>= 1;
            }
            System.out.println(max);
        }
    }
}
