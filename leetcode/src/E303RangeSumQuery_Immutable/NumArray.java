package E303RangeSumQuery_Immutable;

/**
 * Time Complexity O(N) for constructor O(1) for query 9ms 73.48%
 * Space Complexity O(N) 45.2MB 68.5%
 */
public class NumArray {
    int[] inorder;
    public NumArray(int[] nums) {
        inorder = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            inorder[i + 1] += nums[i] + inorder[i];
        }
    }

    public int sumRange(int left, int right) {
        return inorder[right + 1] - inorder[left];
    }
}
