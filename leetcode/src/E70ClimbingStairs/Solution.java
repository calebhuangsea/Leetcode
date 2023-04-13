package E70ClimbingStairs;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
