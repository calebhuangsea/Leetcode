package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            boolean flag = true;
            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) == -1) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
    }
}
