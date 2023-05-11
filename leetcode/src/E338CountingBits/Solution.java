package E338CountingBits;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }


    /**
     * Time: O(Nlog(N))
     * Space: O(N)
     */
    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num > 0) {
                res[i] += num & 1;
                num >>= 1;
            }
        }
        return res;
    }
}
