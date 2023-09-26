package M625MinimumFactorization;

public class Solution {
    /**
     * Time: O(8log(n))
     * Space: O(1)
     */
    public int smallestFactorization(int num) {
        if (num < 2) {
            return num;
        }
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                res = res + i * mul;
                mul *= 10;
                num /= i;
                if (res > Integer.MAX_VALUE) {
                    return 0;
                }
            }
        }
        return num < 2 ? (int)res : 0;
    }
}
