package M343IntegerBreak;

public class Solution {
    public int integerBreak(int n) {
        int max = 0;
        for (int i = 2; i <= n; i++) {
            max = Math.max(breakint(n, i), max);
        }
        return max;
    }

    private int breakint(int n, int times) {
        int res = 1;
        while (n > 0) {
            int x = n / times--;
            n -= x;
            res *= x;
        }
        return res;
    }
}
