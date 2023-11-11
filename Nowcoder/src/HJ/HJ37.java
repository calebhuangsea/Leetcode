package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;
        for (int i = 3; i <= n; i++) {
            n3 += n2;
            n2 = n1;
            n1 = n3;
        }
        System.out.print(n1 + n2 + n3);
    }
}
