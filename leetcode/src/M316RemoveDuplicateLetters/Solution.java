package M316RemoveDuplicateLetters;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - 'a'] = i;
        }

        boolean[] seen = new boolean[26];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i] - 'a';
            if (seen[curr]) {continue;}
            while (!stack.isEmpty() && stack.peek() > curr && last[stack.peek()] > i) {
                seen[stack.pop()] = false;
            }
            stack.push(curr);
            seen[curr] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append((char) (stack.pop() + 'a'));
        return sb.reverse().toString();
    }
}
