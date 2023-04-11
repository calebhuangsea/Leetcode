package M106ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        post_idx = postorder.length - 1;
        this.postorder = postorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_idx]);
        int index = idx_map.get(root.val);
        post_idx--;
        root.right = helper(index + 1, inEnd);
        root.left = helper(inStart, index - 1);
        return root;
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
