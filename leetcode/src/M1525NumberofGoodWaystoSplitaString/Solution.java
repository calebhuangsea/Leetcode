package M1525NumberofGoodWaystoSplitaString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int numSplits(String s) {
        char[] string = s.toCharArray();
        int[] prefix = new int[string.length];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < prefix.length; i++) {
            set.add(string[i]);
            prefix[i] = set.size();
        }
        set.clear();
        int sum = 0;
        for (int i = string.length - 1; i > 0; i--) {
            set.add(string[i]);
            if (set.size() == prefix[i - 1]) {
                sum++;
            }
        }
        return sum;
    }
}
