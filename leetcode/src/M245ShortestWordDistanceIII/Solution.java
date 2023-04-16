package M245ShortestWordDistanceIII;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int shortestWordDistance(String[] w, String word1, String word2) {
        int n = w.length;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            while (i < n && !w[i].equals(word1)) {
                i++;
            }
            while (j < n && !w[j].equals(word2)) {
                j++;
            }
            if (i >= n || j >= n) {
                break;
            }
            if (i != j) {
                min = Math.min(min, Math.abs(i - j));
            }
            if (i < j) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
