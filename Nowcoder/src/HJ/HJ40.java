package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int english = 0, space = 0, num = 0, other = 0;
        char[] s = in.nextLine().toCharArray();
        for (char c : s) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') english++;
            else if (c == ' ') space++;
            else if (c >= '0' && c <= '9') num++;
            else other++;
        }
        System.out.println(english);
        System.out.println(space);
        System.out.println(num);
        System.out.println(other);
    }
}