package E1732FindtheHighestAltitude;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int largestAltitude(int[] gain) {
        int[] pre = new int[gain.length + 1];
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            pre[i + 1] = pre[i] + gain[i];
            max = Math.max(max, pre[i + 1]);
        }
        return max;
    }
}
