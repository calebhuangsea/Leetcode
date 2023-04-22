package src.M6ZigzagConversion;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public String convert(String s, int row) {
        int n = s.length();
        int len = 2 * row - 2;
        if (len == 0) {
            return s;
        }
        int cycle = n / len;
        int left = n % len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cycle; i++) {
            sb.append(s.charAt(i * len));
        }
        if (left != 0) {
            sb.append(s.charAt(cycle * len));
        }
        for (int j = 1; j <= row - 2; j++) {
            for (int i = 0; i < cycle; i++) {
                sb.append(s.charAt(i * len + j));
                sb.append(s.charAt(i * len + (len - j)));
            }
            if (j < left) {
                sb.append(s.charAt(cycle * len + j));
            }
            if ((len - j) < left) {
                sb.append(s.charAt(cycle * len + (len - j)));
            }
        }
        for (int i = 0; i < cycle; i++) {
            sb.append(s.charAt(i * len + row - 1));
        }
        if (left >= row) {
            sb.append(s.charAt(cycle * len + row - 1));
        }
        return sb.toString();
    }
}
