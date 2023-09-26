package M29DivideTwoIntegers;

public class Solution {
    /**
     * Time: O(Q)
     * Space: O(1)
     */
    public int divide(int dividend, int divisor) {
        boolean pos = true;
        if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (dividend > 0) {
            dividend = -dividend;
            pos = !pos;
        }
        if (divisor > 0) {
            pos = !pos;
            divisor = -divisor;
        }
        int q = 0;
        while (dividend <= divisor) {
            q++;
            dividend -= divisor;
        }
        if (q > Integer.MAX_VALUE) {
            q = Integer.MAX_VALUE;
        }
        if (!pos) {
            return -q;
        }
        return q;

    }
}
