package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] a = in.nextLine().toCharArray();
        char[] b = in.nextLine().toCharArray();
        for (char c : a) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    // special case
                    System.out.print('A');
                } else {
                    System.out.print((char)(c + 1 - 'a' + 'A'));
                }
            }
            if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    // special case
                    System.out.print('a');
                } else {
                    System.out.print((char)(c + 1 - 'A' + 'a'));
                }
            }
            if (c >= '0' && c <= '9') {
                if (c == '9') System.out.print('0');
                else System.out.print((char)(c + 1));
            }
        }
        System.out.println();
        for (char c : b) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    // special case
                    System.out.print('Z');
                } else {
                    System.out.print((char)(c - 1 - 'a' + 'A'));
                }
            }
            if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    // special case
                    System.out.print('z');
                } else {
                    System.out.print((char)(c - 1 - 'A' + 'a'));
                }
            }
            if (c >= '0' && c <= '9') {
                if (c == '0') System.out.print('9');
                else System.out.print((char)(c - 1));
            }
        }
    }
}
