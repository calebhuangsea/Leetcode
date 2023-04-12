package E257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        find(root, res, new StringBuilder());
        return res;
    }

    private void find(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) {
            return;
        }
        int len = (node.val + "").length();
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            res.add(sb.toString());
            sb.delete(sb.length() - len, sb.length());
            return;
        }
        sb.append(node.val);
        sb.append("->");
        if (node.left != null) {
            find(node.left, res, sb);
        }
        if (node.right != null) {
            find(node.right, res, sb);

        }
        sb.delete(sb.length() - len - 2, sb.length());
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
