package M199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(H)
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }
    private void helper(TreeNode node, int level) {
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, node.val);
        }
        // res.add(level, node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
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
