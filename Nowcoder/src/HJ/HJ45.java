package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int times = in.nextInt();
        while (times-- > 0) {
            char[] s = in.next().toCharArray();
            int[] count = new int[26];
            int score = 26;
            int sum = 0;
            for (char c : s) {
                count[c - 'a']++;
            }
            Arrays.sort(count);
            for (int i = count.length - 1; i >= 0; i--) {
                int n = count[i];
                if (n == 0) break;
                sum += n * score--;
            }
            System.out.println(sum);
        }
    }
}