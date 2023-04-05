package E392IsSubsequence;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 40.7MB 29.93%
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {return true;}
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            char c1 = s.charAt(i);
            int index = t.indexOf(c1, j);
            if (index == -1) {
                return false;
            }
            j = index + 1;
            i++;
        }
        return i == s.length();
    }
}
