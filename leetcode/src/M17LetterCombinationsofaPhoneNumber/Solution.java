package M17LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Time Complexity O(4^N)
     * Space Complexity O(N)
     */
    List<String> res = new ArrayList<>();
    Map<Integer, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        map = new HashMap<>();
        map.put(2, new char[] {'a','b','c'});
        map.put(3, new char[] {'d','e','f'});
        map.put(4, new char[] {'g', 'h', 'i'});
        map.put(5, new char[] {'j', 'k', 'l'});
        map.put(6, new char[] {'m', 'n', 'o'});
        map.put(7, new char[] {'p', 'q', 'r', 's'});
        map.put(8, new char[] {'t', 'u', 'v'});
        map.put(9, new char[] {'w', 'x', 'y', 'z'});
        dfs(digits.toCharArray(), 0, new StringBuilder());
        return res;
    }

    private void dfs(char[] digits, int i, StringBuilder sb) {
        if (sb.length() == digits.length) {
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits[i] - '0')) {
            sb.append(c);
            dfs(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
