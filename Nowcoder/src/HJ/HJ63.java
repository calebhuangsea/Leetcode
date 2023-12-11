package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s = in.nextLine().toCharArray();
        int n = in.nextInt();
        int index = n - 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'C' || s[i] == 'G') count++;
        }
        int max = count;
        // 0 1 2 3
        //
        for (int i = n; i < s.length; i++) {
            if (s[i] == 'C' || s[i] == 'G') count++;
            if (s[i - n] == 'C' || s[i - n] == 'G') {
                count--;
            }
            if (count > max) {
                index = i;
                max = count;
            }
        }
        for (int i = index - n + 1; i <= index; i++) System.out.print(s[i]);

    }
}
