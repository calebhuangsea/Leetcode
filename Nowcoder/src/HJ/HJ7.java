package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        if (n - (int) n >= 0.5) {
            System.out.println((int) (n + 1));
        } else {
            System.out.println((int) n);
        }
    }
}
