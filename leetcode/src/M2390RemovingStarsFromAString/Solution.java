package M2390RemovingStarsFromAString;

import java.util.Stack;
public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
