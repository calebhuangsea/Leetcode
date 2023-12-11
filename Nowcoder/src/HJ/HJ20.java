package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String pwd = in.nextLine();
            if (pwd.length() < 8) {
                System.out.println("NG");
                continue;
            }
            int lower = 0, upper = 0, number = 0, other = 0;
            for (int i = 0; i < pwd.length(); i++) {
                char c = pwd.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    lower = 1;
                }
                else if (c >= 'A' && c <= 'Z') {
                    upper = 1;
                }
                else if (c >= '0' && c <= '9') {
                    number = 1;
                } else {
                    other = 1;
                }
            }
            if (lower + upper + number + other < 3) {
                System.out.println("NG");
                continue;
            }
            int n = pwd.length();
            boolean flag = true;
            for (int i = 0; i < (n + 1) / 2; i++) {
                for (int j = i + 3; j <= n; j++) {
                    String sub = pwd.substring(i, j);
                    if (pwd.indexOf(sub, i + 1) != -1) {

                        flag = false;
                    }
                }
            }
            if (!flag) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
