package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String num = in.next();
            int res = 0;
            int base = 1;
            for (int i = num.length() - 1; i >= 2; i--) {
                char c = num.charAt(i);
                if (c >= '0' && c <= '9') {
                    res += base * (c - '0');
                } else {
                    res += base * (c - 'A' + 10);
                }
                base *= 16;
            }
            System.out.println(res);
        }
    }
}
