package H1220CountVowelsPermutation;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    int mod = (int)1e9 + 7;
    public int countVowelPermutation(int n) {
        long res = 0;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int iii = 1; iii < n; iii++) {
            long aa = (i + e + u) % mod;
            long ee = (i + a) % mod;
            long ii = (e + o) % mod;
            long oo = i;
            long uu = (i + o) % mod;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        res = (a + e + i + o + u) % mod;
        return (int)res;
    }
}
