package H76MinimumWindowSubstring;

import java.util.*;

public class Solution {
    /**
     * Sliding window
     * Time Complexity O(s + t) 19ms 59.42%
     * Space Complexity O(s + t) 43.8MB 13.56%
     */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> require = new HashMap<>();
        for (char c : t.toCharArray()) {
            require.put(c, require.getOrDefault(c, 0) + 1);
        }
        int len = require.size();
        int l = 0;
        int r = 0;
        int soFar = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> curr = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            curr.put(c, curr.getOrDefault(c, 0) + 1);
            if (require.containsKey(c) && require.get(c).intValue() == curr.get(c).intValue()) {
                soFar++;
            }
            // if the window is formed, try to contract and update the left boundary
            while (l <= r && soFar == len) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                curr.put(c, curr.get(c) - 1);
                if (require.containsKey(c) && curr.get(c).intValue() < require.get(c).intValue()) {
                    soFar--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
