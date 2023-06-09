package M1578MinimumTimetoMakeRopeColorful;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int minCost(String colors, int[] time) {
        char[] cc = colors.toCharArray();
        int cost = 0;

        int sum = time[0];
        int max = time[0];
        for (int i = 1; i < cc.length; i++) {
            char c = cc[i];
            if (c != cc[i - 1]) {
                cost += sum - max;
                max = time[i];
                sum = time[i];

            } else {
                max = Math.max(time[i], max);
                sum += time[i];
            }
        }
        cost += sum - max;
        return cost;
    }
}
