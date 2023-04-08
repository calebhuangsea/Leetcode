package E409LongestPalindrome;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(128) 41.1MB 45.31%
     */
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        int sum = 0;
        for (char c : s.toCharArray()) {
            arr[c]++;
            if (arr[c] == 2) {
                arr[c] = 0;
                sum+=2;
            }
        }
        return sum == s.length() ? sum : sum + 1;
    }
}
