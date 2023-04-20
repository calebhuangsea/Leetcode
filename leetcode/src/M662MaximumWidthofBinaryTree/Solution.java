package M662MaximumWidthofBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Time: O(V + E)
     * Space: O(H)
     */
    int max = 1;
    Map<Integer, Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return max;
    }

    private void dfs(TreeNode root, int level, int index) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, index);
        }
        int left = map.get(level);
        max = Math.max(max, index - left + 1);
        dfs(root.left, level + 1, index * 2);
        dfs(root.right, level + 1, index * 2 + 1);
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
