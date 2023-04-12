package M71SimplifyPath;

import java.util.Stack;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int from = 0;
        while (true) {
            int left = path.indexOf('/', from);
            if (left == -1) {
                break;
            }
            while (left < path.length()) {
                char c = path.charAt(left);
                if (c == '/') {
                    left++;
                } else {
                    break;
                }
            }
            int right = path.indexOf('/', left);
            right = right == -1 ? path.length() : right;
            String stuff = path.substring(left, right);
            if (stuff.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if (!stuff.equals(".")) {
                stack.push(stuff);
            }
            while (right < path.length()) {
                char c = path.charAt(right);
                if (c == '/') {
                    right++;
                } else {
                    break;
                }
            }
            from = right - 1;
            if (from == path.length() - 1) {
                break;
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
