package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ99 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                String s = i * i + "";
                // 12345 45
                // System.out.println(i + " yo " + s);
                // System.out.println(s.lastIndexOf(i + ""));
                // System.out.println(s.length() - (i + "").length());
                if (s.lastIndexOf(i + "") == s.length() - (i + "").length()) {

                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
