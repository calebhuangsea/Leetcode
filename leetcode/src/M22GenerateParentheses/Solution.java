package M22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(2^N)
     * Space Complexity O(N)
     */
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(new StringBuilder(), n, n);
        return res;
    }

    private void helper(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left >= 0) {
            sb.append("(");
            helper(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right) {
            sb.append(")");
            helper(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
