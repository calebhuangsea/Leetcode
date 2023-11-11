package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            int index = 0;
            while (index + 8 <= next.length()) {
                System.out.println(next.substring(index, index + 8));
                index += 8;
            }
            int diff = 8 - next.length() + index;
            if (index == next.length()) continue;
            System.out.print(next.substring(index));
            for (int i = 0; i < diff; i++) System.out.print(0);
            System.out.println();
        }
    }
}
