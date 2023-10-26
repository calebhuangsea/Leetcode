package M1660CorrectaBinaryTree;

import java.util.*;

class Solution {
     public class TreeNode {
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
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public TreeNode correctBinaryTree(TreeNode root) {
        // bfs to find nodes in every level: if curr is in the next level, trouble
        Deque<TreeNode[]> dq = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        dq.offer(new TreeNode[]{root, null});
        set.add(root);
        while (!dq.isEmpty()) {
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                TreeNode[] curr = dq.poll();
                if (curr[0].right != null) {
                    if (set.contains(curr[0].right)) {
                        // we want to remove curr[0]
                        if (curr[1].left == curr[0]) {
                            curr[1].left = null;
                        } else {
                            curr[1].right = null;
                        }
                        return root;
                    }
                    set.add(curr[0].right);
                    dq.offer(new TreeNode[]{curr[0].right, curr[0]});
                }
                if (curr[0].left != null) {
                    set.add(curr[0].left);
                    dq.offer(new TreeNode[]{curr[0].left, curr[0]});
                }

            }
        }
        return null;
    }
}
