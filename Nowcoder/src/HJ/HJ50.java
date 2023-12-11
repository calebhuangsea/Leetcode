package HJ;

import java.util.*;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        s = s.replace("{", "(");
        s = s.replace("[", "(");
        s = s.replace("}", ")");
        s = s.replace("]", ")");
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int nxt = findNext(s, i + 1, '(', ')');
                num = solve(s.substring(i + 1, nxt));
                i = nxt;
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') stack.add(num);
                else if (sign == '-') stack.add(-num);
                else if (sign == '*') stack.add(stack.pop() * num);
                else if (sign == '/') stack.add(stack.pop() / num);
                sign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    private static int findNext(String s, int start, char c1, char c2) {
        int count = 1;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == c1) {
                count++;
            }
            if (c == c2) {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return - 1;
    }
}