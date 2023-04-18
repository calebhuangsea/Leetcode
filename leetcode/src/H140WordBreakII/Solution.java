package H140WordBreakII;

import java.util.*;

public class Solution {
    /**
     * Time: O(2^N)
     * Space: O(2^N)
     */
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(0, s, wordDict, new StringBuilder());
        return res;
    }

    private void dfs(int index, String s, List<String> dict, StringBuilder sb) {
        if (index == s.length()) {
            res.add(sb.toString().trim());
            return;
        }
        for (String word : dict) {
            if (s.indexOf(word, index) == index) {
                sb.append(" ");
                sb.append(word);
                dfs(index + word.length(), s, dict, sb);
                for (int i = 0; i <= word.length(); i++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
