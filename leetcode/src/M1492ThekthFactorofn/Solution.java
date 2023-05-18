package M1492ThekthFactorofn;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int kthFactor(int n, int k) {
        int count = 0;
        int fac = 1;
        while (fac <= n) {
            if (n % fac == 0) {
                count++;
            }
            if (count == k) {
                return fac;
            }
            fac += 1;
        }
        return -1;
    }
}
