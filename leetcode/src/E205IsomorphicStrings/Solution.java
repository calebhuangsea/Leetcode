package E205IsomorphicStrings;

import java.util.Arrays;

public class Solution {
    /**
     * Time Complexity O(N) 5ms 91.72%
     * Space Complexity O(256) 42.1MB 79.68%
     */
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (st[c1] == -1 && ts[c2] == -1) {
                st[c1] = c2;
                ts[c2] = c1;
            }
            if (st[c1] != c2 || ts[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}
