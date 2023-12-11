package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] token = in.nextLine().split("\\.");
        if (token.length != 4) {
            System.out.println("NO");
            return;
        }
        for (String t : token) {
            if (t.length() == 0 || t.indexOf('0') == 0 && t.length() != 1) {
                System.out.println("NO");
                return;
            }
            for (int i = 0; i < t.length(); i++) {
                if (!Character.isDigit(t.charAt(i))) {
                    System.out.println("NO");
                    return;
                }
                int n = Integer.parseInt(t);
                if (n > 255) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
