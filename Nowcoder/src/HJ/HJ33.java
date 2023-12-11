package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区
        String ss = in.nextLine();

        String[] tokens = ss.split("\\.");
        long num = Long.parseLong(in.nextLine());
        long res = 0;
        for (int i = 0; i <= 3; i++) {
            int n = Integer.parseInt(tokens[3 - i]);
            for (int j = 0; j < 8; j++) {
                if ((n & 1) == 1) {
                    res += Math.pow(2, i * 8 + j);
                }
                n >>= 1;
            }
        }
        System.out.println(res);
        String res2 = "";
        for (int i = 0; i < 4; i++) {
            int n = 0;
            for (int j = 0; j < 8; j++) {
                if ((num & 1) == 1) n += Math.pow(2, j);
                num >>= 1;
            }
            res2 = n + "." + res2;
        }
        System.out.println(res2.substring(0, res2.length() - 1));
    }
}
