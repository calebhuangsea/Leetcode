package H32LongestValidParentheses;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param ss
     * @return
     */
    public int longestValidParentheses(String ss) {
        char[] arr = ss.toCharArray();
        Stack<Integer> s = new Stack<>();
        // dp[i] means that we have length x end in index i
        int[] dp = new int[arr.length];
        int max = 0;
        // int start = 0;
        // int end = 0;
        for (int r = 0; r < arr.length; r++) {
            char c = arr[r];
            if (c == ')' && !s.isEmpty() && arr[s.peek()] == '(') {
                // only situation we wanna pop
                // i is new end, s.pop() is new start
                // check(()) and ()()
                int l = s.pop();
                dp[r] = 2;
                if (dp[r - 1] > 0) {
                    dp[r] += dp[r - 1];
                }
                if (l - 1 >= 0 && dp[l - 1] > 0) {
                    dp[r] += dp[l - 1];
                }
                max = Math.max(max, dp[r]);
            } else {
                s.push(r);
            }
        }
        return max;
    }
}
