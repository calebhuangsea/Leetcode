package Biweekly102;

import java.util.*;

public class Q3 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        construct(root, 0);
        build(root, 0);
        root.val = 0;
        return root;
    }

    private void construct(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.left != null) {
            sum += root.right.val;
        }
        map.put(level, map.getOrDefault(level, 0) + sum);
        construct(root.left, level + 1);
        construct(root.right, level + 1);
    }

    private void build(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int sum = 0;
        int total = map.get(level);
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.left != null) {
            sum += root.right.val;
        }
        if (root.left != null) {
            root.left.val = total - sum;
        }
        if (root.right != null) {
            root.right.val = total - sum;
        }
        build(root.left, level + 1);
        build(root.right, level + 1);
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
