package M1448CountGoodNodesinBinaryTree;

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
     * Time: O(E+V)
     * Space: O(H)
     */
    int num = 1;
    public int goodNodes(TreeNode root) {
        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return num;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        num += node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
