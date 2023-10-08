package E557ReverseWordsinaStringIII;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = word.length() - 1; i>= 0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(s.length());
        return sb.toString();
    }
}
