package M131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(N * 2^N)
     * Space: O(N)
     */
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>());
        return res;
    }

    private void dfs(String s, List<String> ls) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(ls));
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (check(sub)) {
                ls.add(sub);
                dfs(s.substring(i), ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
