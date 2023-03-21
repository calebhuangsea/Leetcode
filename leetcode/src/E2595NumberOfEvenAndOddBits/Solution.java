package E2595NumberOfEvenAndOddBits;

public class Solution {
    /**
     * Find how many bits we have and then use & bit manipulation
     * Time Complexity O(log(N)) 1ms 99.94%
     * Space Complexity O(1) 42.3MB 83.16%
     */
    public int[] evenOddBit(int n) {
        int i = 1;// 2^0
        int count = 0;
        while (i <= n) {
            i *= 2;
            count++;
        }
        i /= 2;
        count--;
        int odd = 0;
        int even = 0;
        i = 1;
        for (int j = 0; j <= count; j++) {
            if ((i & n) != 0) {
                if (j % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            i*=2;
        }
        return new int[] {even, odd};
    }
}
