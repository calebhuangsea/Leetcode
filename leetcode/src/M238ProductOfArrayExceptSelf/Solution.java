package M238ProductOfArrayExceptSelf;

public class Solution {
    /**
     * inorder product and reverse order product
     * Time Complexity O(N) 2ms 47.22%
     * Space Complexity O(N) 50.9MB 43.24%
     */
    public int[] productExceptSelf(int[] nums) {
        // left and right
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // res[i] = previous product with not this one
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
