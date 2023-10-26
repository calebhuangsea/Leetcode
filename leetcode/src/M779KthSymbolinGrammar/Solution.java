package M779KthSymbolinGrammar;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int total = (int) Math.pow(2, (n - 1));
        int half = total / 2;
        if (k > half) {
            return 1 - kthGrammar(n - 1, k - half);
        } else {
            return kthGrammar(n - 1, k);
        }
    }
}
