package M107BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * BFS
     * Time Complexity O(V + E) 1ms 92.72%
     * Space Complexity O(V) 43.4MB 5.1%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.add(root);
        q.add(null);
        res.add(new ArrayList<>());
        while (q.size() > 0) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(0, new ArrayList<>());
                continue;
            }
            res.get(0).add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (q.size() > 0 && q.peek() == null) {
                if (q.size() == 1) {
                    break;
                }
                q.add(null);
            }
        }
        return res;
    }


}
