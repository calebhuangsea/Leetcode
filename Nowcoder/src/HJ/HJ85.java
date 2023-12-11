package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ85 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();
            int max = 1;
            for (int i = 0; i < s.length(); i++) {
                max = Math.max(solve(s, i, i + 1), max);
                max = Math.max(solve(s, i, i), max);
            }
            System.out.println(max);
        }
    }

    private static int solve(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                // 1 2 3 4 5
                return r - l - 1;
            }
            l--;
            r++;
        }
        return r - l - 1;
    }
}
