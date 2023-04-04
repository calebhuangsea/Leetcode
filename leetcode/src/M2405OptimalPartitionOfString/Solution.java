package M2405OptimalPartitionOfString;

import java.util.Arrays;

public class Solution {
    /**
     * Two pointer and hashtable
     * Time Complexity: O(N) 11ms 85.92%
     * Space Complexity: O(1) 42.8MB 88.1%
     */
    public int partitionString(String s) {
        int[] lastseen = new int[26];
        int count = 1;
        Arrays.fill(lastseen, -1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastseen[s.charAt(i) - 'a'] >= start) {
                // means that we see a duplicate within this substring
                count++;
                start = i;
            }
            lastseen[s.charAt(i) - 'a'] = i;
        }
        return count;
    }
}
