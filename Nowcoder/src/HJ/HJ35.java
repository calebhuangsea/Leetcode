package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int i = 1;
        int inc = 1;
        while (n > 0) {
            int last = i;
            System.out.print(last + " ");
            for (int j = inc + 1; j < n + inc; j++) {
                last += j;
                System.out.print(last + " ");
            }
            System.out.println();
            i += inc++;
            n--;
        }
    }
}
