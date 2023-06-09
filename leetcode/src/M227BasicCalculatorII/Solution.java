package M227BasicCalculatorII;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Stack, calculate division and multiplication first
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = (curr * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(curr);
                } else if (op == '-') {
                    stack.push(curr * -1);
                } else if (op == '*') {
                    stack.push(curr * stack.pop());
                } else if (op == '/') {
                    stack.push(stack.pop() / curr);
                }
                op = c;
                curr = 0;
            }
        }
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        return sum;
    }
}
