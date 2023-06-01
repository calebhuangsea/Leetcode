package M198HouseRobber;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int rob(int[] nums) {
        int pp = 0;
        int p = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int newp = Math.max(p, pp + nums[i]);
            pp = p;
            p = newp;
        }
        return p;
    }
}
