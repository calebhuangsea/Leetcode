package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        double n = in.nextDouble();
        double sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += n;
            n /= 2;
            sum += n;
        }
        sum -= n;
        System.out.println(sum);
        System.out.println(n);
    }
}
