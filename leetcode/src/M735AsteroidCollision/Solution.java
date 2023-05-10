package M735AsteroidCollision;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.push(a[i]);
                continue;
            }
            int previous = stack.pop();
            int curr = a[i];
            if (previous > 0 && curr < 0) { // that we need to remove 1 or 2
                if (Math.abs(previous) == Math.abs(curr)) {
                    continue; // because we break both
                } else if (Math.abs(previous) > Math.abs(curr)) {
                    stack.push(previous);
                } else {
                    i -= 1;
                }
            } else {
                stack.push(previous);
                stack.push(curr);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = stack.pop();
        }
        return res;
    }
}
