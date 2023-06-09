package E1758MinimumChangesToMakeAlternatingBinaryString;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int minOperations(String s) {
        // start from 0
        int c0 = 0;
        int c1 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i * 2) == '0') {
                c1++;
            } else {
                c0++;
            }
            if (s.charAt(i * 2 + 1) == '1') {
                c1++;
            } else {
                c0++;
            }
        }
        if (s.length() % 2 == 1) {
            if (s.charAt(s.length() - 1) == '0') {
                c1++;
            } else {
                c0++;
            }
        }
        return Math.min(c0, c1);
    }
}
