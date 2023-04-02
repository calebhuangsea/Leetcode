package M11ContainerWithMostWater;

public class Solution {
    /**
     * Time Complexity O(N) 4ms 68.69%
     * Space Complexity O(1) 52.8MB 33.29%
     */
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (lo < hi) {
            int area = Math.min(height[lo], height[hi]) * (hi - lo);
            max = Math.max(area, max);
            if (height[lo] > height[hi]) {
                hi--;
            } else {
                lo++;
            }
        }
        return max;
    }
}
