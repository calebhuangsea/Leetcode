package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine(), b = in.nextLine();
        if (a.length() > b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        int max = 0;
        for (int i = 0; i < a.length() - max; i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                String sub = a.substring(i, j);
                if (b.contains(sub)) {
                    max = Math.max(max, j - i);
                } else {
                    break;
                }
            }
        }
        System.out.print(max);
    }
}