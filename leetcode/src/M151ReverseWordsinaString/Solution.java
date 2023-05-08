package M151ReverseWordsinaString;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i + 1, i + len + 1) + " ");
                len = 0;
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                i++;
            } else {
                len++;
            }
        }
        sb.append(s.substring(0, len));
        return sb.toString();
    }
}
