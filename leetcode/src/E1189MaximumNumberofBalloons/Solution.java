package E1189MaximumNumberofBalloons;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }
        int min = count['b' - 'a'];
        min = Math.min(min, count['a' - 'a']);
        min = Math.min(min, count['l' - 'a'] / 2);
        min = Math.min(min, count['o' - 'a'] / 2);
        min = Math.min(min, count['n' - 'a']);
        return min;
    }
}
