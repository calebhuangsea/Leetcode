package E345ReverseVowelsOfAString;

import java.util.*;

public class Solution {
    /**
     * Two pointers
     * Time Complexity O(N) 6ms 51.43%
     * Space Complexity O(1) 43.1MB 41.42%
     */
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int lo = 0;
        int hi = c.length - 1;
        while (lo < hi) {
            boolean left = set.contains(c[lo]);
            boolean right = set.contains(c[hi]);
            if (left && right) {
                char temp = c[lo];
                c[lo] = c[hi];
                c[hi] = temp;
                lo++;
                hi--;
            } else if (left) {
                hi--;
            } else {
                lo++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char cc : c) {
            sb.append(cc);
        }
        return sb.toString();
    }
}
