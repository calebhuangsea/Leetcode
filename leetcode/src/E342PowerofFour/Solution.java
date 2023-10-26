package E342PowerofFour;

public class Solution {
    /**
     * Time: O(logN)
     * Space: O(1)
     */
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int index = 0;
        int count = 0;
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
                index = i;
                if (count > 1) {
                    return false;
                }
            }
            n /= 2;
            i++;
        }
        return index % 2 == 0;
    }
}
