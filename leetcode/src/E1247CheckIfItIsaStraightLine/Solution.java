package E1247CheckIfItIsaStraightLine;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean checkStraightLine(int[][] c) {
        int[] p1 = c[0];
        int[] p2 = c[1];
        double rate = (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);

        for (int i = 2; i < c.length; i++) {
            p1 = c[i - 1];
            p2 = c[i];
            double rate2 = (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]);
            if ((rate2 != Double.POSITIVE_INFINITY && rate2 != Double.NEGATIVE_INFINITY) && rate2 != rate) {
                return false;
            } else if ((rate2 == Double.POSITIVE_INFINITY || rate2 == Double.NEGATIVE_INFINITY) && (rate != Double.POSITIVE_INFINITY && rate != Double.NEGATIVE_INFINITY)) {
                return false;
            }

        }
        return true;
    }
}
