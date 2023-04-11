package M235LowestCommonAncestorofaBinarySearchTree;

public class Solution {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int v = root.val;
        int pv = p.val;
        int qv = q.val;

        if (pv < v && qv < v) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (pv > v && qv > v) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
