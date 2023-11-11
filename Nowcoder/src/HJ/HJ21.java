package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s = in.next().toCharArray();
        for (char c : s) {
            if (c >= '0' && c <= '9') System.out.print(c);
            if (c >= 'a' && c <= 'c') System.out.print(2);
            if (c >= 'd' && c <= 'f') System.out.print(3);
            if (c >= 'g' && c <= 'i') System.out.print(4);
            if (c >= 'j' && c <= 'l') System.out.print(5);
            if (c >= 'm' && c <= 'o') System.out.print(6);
            if (c >= 'p' && c <= 's') System.out.print(7);
            if (c >= 't' && c <= 'v') System.out.print(8);
            if (c >= 'w' && c <= 'z') System.out.print(9);
            if (c == 'Z') System.out.print('a');
            if (c >= 'A' && c < 'Z') System.out.print((char)(c + 1 - 'A' + 'a'));
        }
    }
}
