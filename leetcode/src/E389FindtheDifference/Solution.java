package E389FindtheDifference;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }
}
