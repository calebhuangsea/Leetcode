package E844BackspaceStringCompare;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (s1.size() != 0) {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (s2.size() != 0) {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }
        if (s1.size() != s2.size()) {
            return false;
        }
        while (s1.size() != 0) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return true;
    }
}
