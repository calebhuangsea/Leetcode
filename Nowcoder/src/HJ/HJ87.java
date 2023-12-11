package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ87 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] s = in.next().toCharArray();
            int upper = 0;
            int lower = 0;
            int num = 0;
            int symbol = 0;
            for (char c : s) {
                if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= 'a' && c <= 'z') {
                    lower++;
                } else if (c >= '0' && c <= '9') {
                    num++;
                } else if (c >= 0x21 && c <= 0x2F || c >= 0x3A && c <= 0x40 ||
                        c >= 0x5B && c <= 0x60 || c >= 0x7B && c <= 0x7E) {
                    symbol++;
                }
            }
            int point = 0;
            if (s.length <= 4) point+=5;
            else if (s.length <= 7) point += 10;
            else point += 25;

            if (num > 1) point += 20;
            else if (num == 1) point += 10;
            if (upper > 0 && lower > 0) {
                point += 20;
            } else if (upper > 0 || lower > 0) point += 10;

            if (symbol > 1) point += 25;
            else if (symbol == 1) point += 10;

            if (upper > 0 && lower > 0 && num > 0 && symbol > 0) point += 5;
            else if ((upper > 0 || lower > 0) && num > 0 && symbol > 0) point += 3;
            else if ((upper > 0 || lower > 0) && num > 0) point += 2;

            if (point >= 90) {
                System.out.println("VERY_SECURE");
            } else if (point >= 80) System.out.println("SECURE");
            else if (point >= 70) System.out.println("VERY_STRONG");
            else if (point >= 60) System.out.println("STRONG");
            else if (point >= 50) System.out.println("AVERAGE");
            else if (point >= 25) System.out.println("WEAK");
            else System.out.println("VERY_WEAK");



        }
    }
}
