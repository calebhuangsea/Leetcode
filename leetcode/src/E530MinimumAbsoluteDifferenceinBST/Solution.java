package E530MinimumAbsoluteDifferenceinBST;

public class Solution {
    /**
     * Inorder left mid right
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        help(root);
        return min;
    }

    private void help(TreeNode root) {
        if (root == null) {return;}
        help(root.left);
        TreeNode prev = pre;
        if (pre != null) {
            min = Math.min(min, Math.abs(pre.val - root.val));
        }
        pre = root;
        help(root.right);
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
