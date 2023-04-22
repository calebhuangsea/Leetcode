package M337HouseRobberIII;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int rob(TreeNode root) {
        int[] r = robbed(root);
        return Math.max(r[0], r[1]);

    }

    private int[] robbed(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = robbed(root.left);
        int[] right = robbed(root.right);
        int[] curr = new int[2];
        // rob this one then we can not rob its child
        curr[0] = root.val + left[1] + right[1];
        // skip this one then we can rob its child or not
        curr[1] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        return curr;
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
