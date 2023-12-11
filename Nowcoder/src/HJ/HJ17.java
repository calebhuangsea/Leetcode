package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = 0, y = 0;
        for (String token : in.nextLine().split(";")) {
            if (token.length() <= 1) continue;
            boolean flag = true;
            for (int i = 1; i < token.length() && flag; i++) {
                if (!Character.isDigit(token.charAt(i))) {
                    flag = false;
                }
            }
            if (!flag) continue;
            int num = Integer.parseInt(token.substring(1));
            if (token.charAt(0) == 'A') {
                x -= num;
            } else if (token.charAt(0) == 'S') {
                y -= num;
            } else if (token.charAt(0) == 'W') {
                y += num;
            } else if (token.charAt(0) == 'D') {
                x += num;
            }
        }
        System.out.println(x + "," + y);
    }
}
