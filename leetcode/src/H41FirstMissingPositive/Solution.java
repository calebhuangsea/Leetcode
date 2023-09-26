package H41FirstMissingPositive;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int firstMissingPositive(int[] nums) {
        boolean[] arr = new boolean[nums.length + 2];
        for (int n : nums) {
            if (n > 0 && n < arr.length) {
                arr[n] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
