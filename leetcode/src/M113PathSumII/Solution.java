package M113PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(N^2)
     * Space Complexity O(N)
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(node.left, targetSum - node.val, list);
        dfs(node.right, targetSum - node.val, list);
        list.remove(list.size() - 1);
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
