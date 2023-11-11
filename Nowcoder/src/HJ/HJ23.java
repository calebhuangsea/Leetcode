package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s = in.next().toCharArray();
        int[] count = new int[26];
        for (char c : s) count[c - 'a']++;
        int min = s.length;
        for (int n : count) {
            if (n != 0) {
                min = Math.min(min, n);
            }
        }
        for (char c : s) {
            if (count[c - 'a'] != min) System.out.print(c);
        }
    }
}