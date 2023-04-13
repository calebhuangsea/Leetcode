package E509FibonacciNumber;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public int fib(int n) {
        int n0 = 0;
        int n1 = 1;
        if (n == 0) {
            return n0;
        } else if (n == 1) {
            return n1;
        }
        for (int i = 2; i <= n; i++) {
            int temp = n0 + n1;
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }
}
