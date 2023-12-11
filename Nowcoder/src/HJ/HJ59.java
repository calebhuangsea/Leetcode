package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s = in.nextLine().toCharArray();
        int[] count = new int[26];
        for (char c : s) count[c - 'a']++;
        for (char c : s) {
            if (count[c - 'a'] == 1) {
                System.out.print(c);
                return;
            }
        }
        System.out.print(-1);
    }
}
