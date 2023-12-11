package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine();
        String b = in.nextLine();
        solve(a, b);
    }

    private static void solve(String a, String b) {
        // a >= b (I mean length)
        if (a.length() < b.length()) {
            solve(b, a);
            return;
        }
        int addition = 0; // additional value
        int i = a.length() - 1, j = b.length() - 1;
        Stack<Integer> s = new Stack<>();
        while (j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0';
            sum += addition;
            addition = sum / 10;
            sum %= 10;
            s.add(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + addition;
            addition = sum / 10;
            sum %= 10;
            s.add(sum);
            i--;
        }
        if (addition > 0) s.add(addition);
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }
}
