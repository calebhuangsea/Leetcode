package M946ValidateStackSequences;

import java.util.Stack;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1) {
            return true;
        }
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (j < popped.length) {
            if (stack.empty()) {
                stack.push(pushed[i++]);
                continue;
            }
            if (stack.peek() == popped[j]) {
                j++;
                stack.pop();
            } else {
                if (i == pushed.length) {
                    return false;
                }
                stack.push(pushed[i++]);
            }
        }
        return stack.isEmpty();
    }
}
