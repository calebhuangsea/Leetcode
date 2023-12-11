package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ65 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        solve(in.nextLine(), in.nextLine());
    }

    private static void solve(String a, String b) {
        if (a.length() > b.length()) {
            solve(b, a);
            return ;
        }
        String max = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                if (j - i > max.length() && b.contains(a.substring(i, j))) {
                    max = a.substring(i,j);
                }
            }
        }
        System.out.println(max);
    }
}
