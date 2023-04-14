package E501FindModeinBinarySearchTree;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(2^N)
     * Space Complexity O(N)
     */
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int max = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        help(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        int val = root.val;
        if (pre == null || pre.val != val) {
            count = 1;
        } else {
            count ++;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(val);
        } else if (count == max) {
            list.add(val);
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
