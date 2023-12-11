package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int[] count = new int[255];
            char[] s = in.next().toCharArray();
            int max = 0;
            for (char c : s) {
                count[c] ++;
                max = Math.max(count[c], max);
            }
            while (max != 0) {
                for (int i = 0; i < count.length - 1; i++) {
                    if (count[i] == max) {
                        System.out.print((char)i);
                        count[i] = 0;
                    }
                }
                max--;
            }
        }
    }
}
