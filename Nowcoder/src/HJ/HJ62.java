package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int count = 0;
            int n = in.nextInt();
            while (n > 0) {
                count += n &1;
                n>>=1;
            }
            System.out.println(count);
        }

    }
}