package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') count++;
            }
            System.out.println(count);
        }
    }
}
