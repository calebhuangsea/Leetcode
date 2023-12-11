package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ73 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int y = in.nextInt(), m = in.nextInt(), d = in.nextInt();
        boolean r = false;
        if (y % 4 == 0) {
            if (!(y % 100 == 0 && y % 400 != 0)) {
                r = true;
            }
        }
        int count = 0;
        if (m > 1) count += 31;
        if (m > 2) count += r ? 29 : 28;
        if (m > 3) count += 31;
        if (m > 4) count += 30;
        if (m > 5) count += 31;
        if (m > 6) count += 30;
        if (m > 7) count += 31;
        if (m > 8) count += 31;
        if (m > 9) count += 30;
        if (m > 10) count += 31;
        if (m > 11) count += 30;
        count += d;
        System.out.print(count);
    }
}
