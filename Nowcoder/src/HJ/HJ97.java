package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int count = 0;
            int sum = 0;
            int neg = 0;
            for (int i = 0; i < a; i++) {
                int n = in.nextInt();
                if (n < 0) {
                    neg++;
                } else if (n > 0) {
                    sum+=n;
                    count++;
                }
            }
            System.out.print(neg + " " + String.format("%.1f", (count == 0 ? 0 : sum * 1.0 / count)));
        }
    }
}
