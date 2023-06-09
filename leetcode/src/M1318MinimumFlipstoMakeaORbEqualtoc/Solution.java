package M1318MinimumFlipstoMakeaORbEqualtoc;

public class Solution {
    /**
     * Time: O(MAX(log(A), log(B), log(C))
     * Space: O(1)
     */
    public int minFlips(int a, int b, int c) {
        int count = 0;
        //  10
        // 110
        while (c != 0) {
            if ((c & 1) == 1 && (b & 1) != 1 && (a & 1) != 1) {
                count += 1;
            }
            if ((c & 1) == 0) {
                if ((a&1) == 1) {
                    count++;
                }
                if ((b&1) == 1) {
                    count++;
                }
            }
            c>>=1;
            a>>=1;
            b>>=1;
        }
        while (a != 0) {
            if ((a & 1) == 1) {
                count++;
            }
            a >>= 1;
        }
        while (b != 0) {
            if ((b & 1) == 1) {
                count++;
            }
            b >>= 1;
        }
        return count;
    }
}
