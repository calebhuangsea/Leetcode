package E20ValidParentheses;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public boolean isValid(String ss) {
        Stack<Character> s = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : ss.toCharArray()) {
            if (s.size() > 0) {
                if (map.getOrDefault(c, 'a') == s.peek()) {
                    s.pop();
                } else {
                    s.push(c);
                }
            } else {
                s.push(c);
            }
        }
        return s.size() == 0;
    }
}
