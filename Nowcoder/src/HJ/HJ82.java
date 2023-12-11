package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ82 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String[] s = in.next().split("/");
            int up = Integer.parseInt(s[0]), base = Integer.parseInt(s[1]);
            for (int i = 0; i < up - 1; i++) {
                System.out.print(1 +"/" + base+"+");
            }
            System.out.println(1 +"/" + base);
        }
    }
}
