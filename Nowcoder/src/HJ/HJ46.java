package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.next();
        int k = in.nextInt();
        System.out.println(s.substring(0, k));
    }
}
