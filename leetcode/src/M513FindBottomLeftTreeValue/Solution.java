package M513FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * BFS with right to left order, update value and return
     * Time Complexity O(V + E) 1ms 67.87%
     * Space Complexity O(V) 42.1MB 65.27%
     */
//    public int findBottomLeftValue(TreeNode root) {
//        int res = -1;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        while (q.size() > 0) {
//            TreeNode node = q.poll();
//            res = node.val;
//            if (node.right != null) {
//                q.add(node.right);
//            }
//            if (node.left != null) {
//                q.add(node.left);
//            }
//        }
//        return res;
//    }

    /**
     * DFS
     * Time Complexity O(V + E) 0ms 100%
     * Space Complexity O(1) 42MB 74.17%
     */
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[] {0, root.val};
        dfs(root, res, 0);
        return res[1];
    }

    private void dfs(TreeNode node, int[] arr, int depth) {
        if (depth > arr[0]) {
            arr[0] = depth;
            arr[1] = node.val;
        }
        if (node.left != null) {
            dfs(node.left, arr, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, arr, depth + 1);
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
