package E1137NthTribonacciNumber;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int nn;
        for (int i = 3; i <= n; i++) {
            nn = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = nn;
        }
        return n2;
    }
}
