package M98ValidateBinarySearchTree;

public class Solution {
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
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer upper, Integer lower) {
        if (node == null) {
            return true;
        }
        if ((upper != null && node.val >= upper) || (lower != null && node.val <= lower)) {
            return false;
        }

        return helper(node.left, node.val, lower) && helper(node.right, upper, node.val);

    }
}
