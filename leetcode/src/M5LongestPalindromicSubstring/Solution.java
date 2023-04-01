package M5LongestPalindromicSubstring;

public class Solution {
    /**
     * Check and expand at every index for odd and even length palindrome
     * Time Complexity O(N^2) 5ms 98.96%
     * Space Complexity O(N) 42.6MB 54.6%
     */
    private int low = 0;
    private int len = 0;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            find(i, i, arr);
            find(i, i + 1, arr);
        }
        return s.substring(low, low + len);
    }

    private void find(int lo, int hi, char[] arr) {
        while (lo >= 0 && hi < arr.length && arr[lo] == arr[hi]) {
            lo--;
            hi++;
        }
        int diff = hi - lo - 1;
        if (diff > len) {
            low = lo + 1;
            len = diff;
        }
    }
}
