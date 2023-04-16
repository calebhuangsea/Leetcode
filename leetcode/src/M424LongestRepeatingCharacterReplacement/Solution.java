package M424LongestRepeatingCharacterReplacement;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int res = 0;
        int sum = 0;
        int start = 0;
        int[] count = new int[26];
        for (int end = 0; end < n; end++) {
            sum = Math.max(sum, ++count[arr[end] - 'A']);
            while (end - start + 1 - sum > k) {
                count[arr[start++] - 'A']--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
