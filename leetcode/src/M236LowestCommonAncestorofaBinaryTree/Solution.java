package M236LowestCommonAncestorofaBinaryTree;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    private boolean helper(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null) {
            return false;
        }
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            res = root;
        }
        return (mid + left + right) > 0;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
