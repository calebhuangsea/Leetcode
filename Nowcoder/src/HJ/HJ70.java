package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {in.nextInt(), in.nextInt()};
        }
        String s = in.next();
        int[] res = solve(s, arr);
        System.out.print(res[2]);
    }

    private static int[] solve(String s, int[][] arr) {
        int[] last = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0 ) {
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                    j++;
                }
                int[] res = solve(s.substring(i + 1, j - 1), arr);
                i = j - 1;
                if (last == null) last = res;
                else {
                    last[2] = last[0] * last[1] * res[1] + res[2] + last[2];
                    last[1] = res[1];
                }
            } else {
                if (last == null) {
                    last = new int[3];
                    last[0] = arr[c - 'A'][0];
                    last[1] = arr[c - 'A'][1];
                    last[2] = 0;
                } else {
                    last[2] = last[0] * last[1] * arr[c - 'A'][1] + last[2];
                    last[1] = arr[c - 'A'][1];
                }
            }
        }
        return last;
    }
}
