package Weekly346;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
    }

    /**
     We can only remove two characters if they are AB or CD,
     we can iterate through the string and use a stack to do the operation
     Time O(N)
     Space: O(N)
     */
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'B' && (!stack.empty() && stack.peek() == 'A')) {
                stack.pop();
            } else if (c == 'D' && (!stack.empty() && stack.peek() == 'C')) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
