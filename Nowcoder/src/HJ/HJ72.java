package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ72 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 25; j++) {
                if (100 - i - j == 3 * (100 - 3 * j - 5 * i)) {
                    System.out.println(i + " " + j + " " + (100 - i - j));
                }
            }
        }
    }
}
