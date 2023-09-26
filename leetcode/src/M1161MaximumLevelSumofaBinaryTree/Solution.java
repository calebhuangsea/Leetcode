package M1161MaximumLevelSumofaBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution {
    /**
     * Time: O(V + E)
     * Space: O(V)
     */
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int sum = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int t = 1;
        while (q.size() > 0) {
            int size = q.size();
            int s = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                s += n.val;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            if (s > sum) {
                level = t;
                sum = s;
            }
            t++;
        }
        return level;
    }
}
