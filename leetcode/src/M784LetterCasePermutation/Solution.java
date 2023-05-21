package M784LetterCasePermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Time: O(N * 2^N)
     * Space: O(N * 2^N)
     */
    List<String> res = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        dfs(new StringBuilder(), s, 0);
        return res;
    }

    private void dfs(StringBuilder curr, String s, int index) {
        if (curr.length() == s.length()) {
            if (visited.contains(curr.toString())) {
                return;
            }
            visited.add(curr.toString());
            res.add(curr.toString());
            return;
        }
        curr.append(Character.toUpperCase(s.charAt(index)));
        dfs(curr, s, index + 1);
        curr.deleteCharAt(curr.length() - 1);
        curr.append(Character.toLowerCase(s.charAt(index)));
        dfs(curr, s, index + 1);
        curr.deleteCharAt(curr.length() - 1);
    }
}
