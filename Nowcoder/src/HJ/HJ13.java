package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] t = in.nextLine().split(" ");
        for (int i = t.length - 1; i >= 0; i--) {
            System.out.print(t[i] + " ");
        }
    }
}