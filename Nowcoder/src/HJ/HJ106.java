package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String[] token = in.nextLine().split(" ");
            for (int i = token.length - 1; i >= 0; i--) {
                for (int j = token[i].length() - 1; j >= 0; j--) {
                    System.out.print(token[i].charAt(j));

                }
                System.out.print(" ");
            }
        }
    }
}
