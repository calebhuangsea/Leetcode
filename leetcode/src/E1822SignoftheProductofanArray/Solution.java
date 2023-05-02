package E1822SignoftheProductofanArray;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            } else if (n < 0) {
                sign *= -1;
            }
        }
        return sign;
    }
}
