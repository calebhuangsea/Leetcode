package M1456MaximumNumberofVowelsinaSubstringofGivenLength;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int maxVowels(String s, int k) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int left = 0;
        int right = k - 1;
        for (int i = left; i <= right; i++) {
            if (set.contains(s.charAt(i))) {
                max++;
            }
        }
        int curr = max;
        while (right + 1< s.length()) {
            if (set.contains(s.charAt(left))) {
                curr--;
            }
            left++;
            right++;
            if (set.contains(s.charAt(right))) {
                curr++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
