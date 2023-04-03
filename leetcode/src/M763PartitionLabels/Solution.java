package M763PartitionLabels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * Time Complexity O(N) 6ms 92.19%
     * Space Complexity O(1) 41.5MB 56.38%
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        int l = 0;
        char c = s.charAt(0);
        int r = s.lastIndexOf(c);
        count[c - 'a'] = r;
        for (int i = 0; i < s.length(); i++) {
            if (i == r) {
                res.add(r - l + 1);
                if (i != s.length() - 1) {
                    c = s.charAt(i + 1);
                    l = r + 1;
                    r = s.lastIndexOf(c);
                }
            } else {
                c = s.charAt(i);
                if (count[c - 'a'] == 0) {
                    count[c - 'a'] = s.lastIndexOf(c);
                    r = Math.max(r, count[c - 'a']);
                }
            }
        }
        return res;
    }
}
