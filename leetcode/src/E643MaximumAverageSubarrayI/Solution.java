package E643MaximumAverageSubarrayI;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = 0;
        int i;
        for (i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum / k;
        while (i < nums.length) {
            sum += nums[i];
            sum -= nums[i - k];
            double res = sum / k;
            if (res > max) {
                max = res;
            }
            i++;
        }
        return max;
    }
}
