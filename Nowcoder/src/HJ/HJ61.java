package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt() / 2;
        int i = 0;
        while (true) {
            if (prime(n - i) && prime(n + i)) {
                System.out.println(n - i + "\n" + (n + i));
                return;
            }
            i++;
        }
    }

    private static boolean prime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
