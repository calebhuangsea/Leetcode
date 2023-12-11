package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int count = 0;
        for (int t = 1; t <= n;t++) {
            int sum = 0;
            for (int i = 1; i <= t / 2; i++) {
                if (t % i == 0) sum += i;
            }
            if (sum == t) count++;
        }

        //输出结果
        System.out.println(count);
    }
}
