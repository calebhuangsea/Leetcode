package M1657DetermineifTwoStringsAreClose;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        for (int i = 0; i < n; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            t1[c1 - 'a']++;
            t2[c2 - 'a']++;
        }
        // check if we can swap t2 to make t2 equals t1
        for (int i = 0; i < 26; i++) {
            if (t1[i] == t2[i]) {
                n -= t1[i];
                t1[i] = 0;
                t2[i] = 0;
            } else {
                if (t1[i] == 0 || t2[i] == 0) {
                    return false;
                }
                for (int j = 0; j < 26; j++) {
                    // find a character in t2 that has the same freq with t1 c1
                    // swap
                    if (t2[j] == t1[i] && t1[j] != 0) {
                        t2[j] = t2[i];
                        t2[i] = 0;
                        n -= t1[i];
                        break;
                    }
                }
            }
        }
        return n == 0;
    }
}
