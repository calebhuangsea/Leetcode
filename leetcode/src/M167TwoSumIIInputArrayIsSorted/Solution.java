package M167TwoSumIIInputArrayIsSorted;

public class Solution {
    /**
     * Time Complexity O(N) 1ms 98.94%
     * Space Complexity O(1) 45.5MB 28.97%
     */
    public int[] twoSum(int[] n, int target) {
        int l = 0;
        int r = n.length - 1;
        int sum;
        while (l < r) {
            sum = n[l] + n[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        return null;
    }
}
