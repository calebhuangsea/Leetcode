package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] s = in.next().toCharArray();
            boolean last = false; // last one is not num
            for (char c : s) {
                if (last) { // last is number
                    if (c < '0' || c > '9') {
                        System.out.print('*');
                        last = false;
                    }
                    System.out.print(c);
                } else { // last is not number
                    if (c >= '0' && c <= '9') {
                        System.out.print('*');
                        last = true;
                    }
                    System.out.print(c);
                }
            }
            if (last) {
                System.out.print('*');
            }
        }
    }
}