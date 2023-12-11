package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String mask = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            mask = toMask(mask);
            if (mask == "") {
                System.out.println(1);
                continue;
            }
            ip1 = toIp(ip1);
            ip2 = toIp(ip2);
            if (ip1 == "" || ip2 == "") {
                System.out.println(1);
                continue;
            }
            boolean flag = true;
            // System.out.println(mask);
            // System.out.println(ip1);
            // System.out.println(ip2);
            for (int i = 31; i >= 0; i--) {
                int n1 = ip1.charAt(i) - '0';
                int n2 = ip2.charAt(i) - '0';
                int m = mask.charAt(i) - '0';

                if ((n1 & m) != (n2 & m)) {
                    System.out.println(2);
                    flag = false;
                    break;
                }
            }
            if (flag )System.out.println(0);
        }
    }

    private static String toIp(String mask) {
        String s = "";
        String[] tokens = mask.split("\\.");
        if (tokens.length != 4) return "";
        for (int i = 3; i >= 0; i--) {
            int n = Integer.parseInt(tokens[i]);
            if (n < 0 || n > 255) return "";
            for (int j = 0; j < 8; j++) {
                s = (n & 1) + s;
                n >>= 1;
            }
        }
        return s;
    }

    private static String toMask(String mask) {
        String s = "";
        String[] tokens = mask.split("\\.");
        if (tokens.length != 4) return "";
        for (int i = 3; i >= 0; i--) {
            int n = Integer.parseInt(tokens[i]);
            if (n < 0 || n > 255) return "";
            for (int j = 0; j < 8; j++) {
                s = (n & 1) + s;
                n >>= 1;
            }
        }
        if (s.indexOf('0') == -1 || s.lastIndexOf('1') < s.indexOf('0')) {
            return s;
        }
        return "";
    }
}
