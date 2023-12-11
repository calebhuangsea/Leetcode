package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ77 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] trains = new int[n];
        for (int i = 0; i < n; i++) trains[i] = in.nextInt();
        Set<String> res = new TreeSet<>();
        solve(trains, 0, "", new Stack<>(), res);
        for (String r : res) {
            for (int i = 0; i < r.length(); i++) {
                System.out.print(r.charAt(i) + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int[] trains, int i, String ans, Stack<Integer> s, Set<String> res) {
        if (ans.length() == trains.length) {
            res.add(ans);
            return;
        }
        if (i < trains.length) {
            // try to add one
            s.push(trains[i]);
            solve(trains, i + 1, ans, s, res);
            s.pop();
        }

        if (!s.isEmpty()) {
            // try to pop one
            int curr = s.pop();
            ans += curr;
            solve(trains, i, ans, s, res);
            s.push(curr);
        }
    }
}
