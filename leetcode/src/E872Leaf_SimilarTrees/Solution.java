package E872Leaf_SimilarTrees;

import java.util.ArrayList;
import java.util.List;

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
     * Time: O(T1 + T2)
     * Space: O(T1 + T2)
     */
    List<Integer> seq1 = new ArrayList<>();
    List<Integer> seq2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, true);
        dfs(root2, false);
        return seq1.equals(seq2);
    }

    private void dfs(TreeNode node, boolean flag) {
        if (node.left == null && node.right == null) {
            if (flag) {
                seq1.add(node.val);
            } else {
                seq2.add(node.val);
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, flag);
        }
        if (node.right != null) {
            dfs(node.right, flag);
        }
    }
}
