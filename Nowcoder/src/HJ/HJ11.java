package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String a = in.nextInt() + "";
            for (int i = a.length() - 1; i >= 0; i--) {
                System.out.print(a.charAt(i));
            }
            System.out.println();
        }
    }
}
