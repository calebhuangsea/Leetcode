package M3LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    /**
     * Two pointers sliding windows, we will update the lo index
     * whenever we find a duplicate character in current window
     * update lo to index + 1
     * Time Complexity: O(N) 2ms 99.93%
     * Space Complexity: O(1) 42.2MB 91.52%
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int lo = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = s.indexOf(c, lo);
            if (index >= lo && index < i) {// if we encounter a duplicate character within current substring
                lo = index + 1;
            }
            max = Math.max(max, i - lo + 1);
        }
        return max;
    }
}
