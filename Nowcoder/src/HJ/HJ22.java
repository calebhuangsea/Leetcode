package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0) break;
            int count = 0;
            int drink = 0;
            while (n >= 2) {
                if (n == 2) {
                    count += 1;
                    break;
                }
                drink = n / 3;
                n = n % 3;
                count += drink;
                n += drink;
            }
            System.out.println(count);

        }
    }
}
