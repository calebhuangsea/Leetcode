package E1768MergeStringsAlternately;

public class Solution {
    /**
     * Time: O(M + N)
     * Space: O(1)
     */
    boolean flag = true;
    public String mergeAlternately(String word1, String word2) {
        if (word1.length() == 0) {
            return word2;
        }
        if (word2.length() == 0) {
            return word1;
        }
        if (flag) {
            flag = false;
            return word1.charAt(0) + mergeAlternately(word1.substring(1), word2);
        } else {
            flag = true;
            return word2.charAt(0) + mergeAlternately(word1, word2.substring(1));
        }
    }
}
