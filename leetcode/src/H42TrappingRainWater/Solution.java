package H42TrappingRainWater;

public class Solution {
    /**
     * Two pointer
     * Time Complexity O(N) 1ms 98.76%
     * Space Complexity O(1) 2.9MB 64.7%
     */
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxL) {
                    maxL = height[left++];
                } else {
                    sum += maxL - height[left++];
                }
            } else {
                if (height[right] >= maxR) {
                    maxR = height[right--];
                } else {
                    sum += maxR - height[right--];
                }
            }
        }
        return sum;
    }
}
