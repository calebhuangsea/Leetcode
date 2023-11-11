package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.next();
        int[] ht = new int[10];
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            if (ht[c] == 0) {
                System.out.print(c);
                ht[c]++;
            }
        }
    }
}