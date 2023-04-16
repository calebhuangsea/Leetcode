package M438FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Sliding Windows
     * Time Complexity O(NM)
     * Space Complexity O(M)
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int[] curr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curr[c - 'a']++;
            if (i >= n) {
                curr[s.charAt(i - n) - 'a']--;
            }
            if (check(target, curr)) {
                res.add(i - n + 1);
            }
        }
        return res;
    }

    private boolean check(int[] n1, int[] n2) {
        for (int i = 0; i < n1.length; i++) {
            if (n1[i] != n2[i]) {
                return false;
            }
        }
        return true;
    }
}
