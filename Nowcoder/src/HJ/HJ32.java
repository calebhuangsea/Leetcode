package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // longest palindrome
        char[] s = in.next().toCharArray();
        int max = 1;
        for (int i = 0; i < s.length; i++) {
            max = Math.max(max, solve(s,i, i));
            max = Math.max(max, solve(s, i, i + 1));
        }
        System.out.println(max);
    }

    private static int solve(char[] s, int i, int j) {
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
