package M129SumRoottoLeafNumbers;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(H)
     */
    int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == 0) {
            sum = root.val;
        } else {
            sum = sum * 10 + root.val;
        }
        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
