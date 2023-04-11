package M889ConstructBinaryTreeFromPreorderAndPostorderTraversal;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, pre.length - 1);
    }

    private TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        // Base cases.
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        // Build root.
        TreeNode root = new TreeNode(pre[preStart]);

        // Locate left subtree.
        int leftSubRootInPre = preStart + 1;
        int leftSubRootInPost = findLeftSubRootInPost(pre[leftSubRootInPre], post, postStart, postEnd);
        int leftSubEndInPre = leftSubRootInPre + (leftSubRootInPost - postStart);

        // Divide.
        TreeNode leftSubRoot = constructFromPrePost(pre, leftSubRootInPre, leftSubEndInPre,
                post, postStart, leftSubRootInPost);
        TreeNode rightSubRoot = constructFromPrePost(pre, leftSubEndInPre + 1, preEnd,
                post, leftSubRootInPost + 1, postEnd - 1);

        // Conquer.
        root.left = leftSubRoot;
        root.right = rightSubRoot;

        return root;
    }

    private int findLeftSubRootInPost(int leftSubRootVal, int[] post, int postStart, int postEnd) {
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == leftSubRootVal) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

//    Map<Integer, Integer> pre = new HashMap<>();
//    Map<Integer, Integer> post = new HashMap<>();
//    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        for (int i = 0; i < preorder.length; i++) {
//            pre.put(preorder[i], i);
//        }
//        for (int i = 0; i < preorder.length; i++) {
//            post.put(postorder[i], i);
//        }
//        return helper(preorder, postorder, 0, preorder.length - 1, postorder.length - 1);
//    }
//
//    private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postEnd) {
//        if (preStart > preEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preStart]);
//        if (preStart == preEnd) {
//            return root;
//        }
//        int preLeftEnd = pre.get(postorder[postEnd - 1]) - 1;
//        int postLeft = post.get(preorder[preStart + 1]);
//        int preRightStart = pre.get(postorder[postEnd - 1]);
//        root.left = helper(preorder, postorder, preStart + 1, preLeftEnd, postLeft);
//        root.right = helper(preorder, postorder, preRightStart, preEnd, postEnd - 1);
//        return root;
//    }

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
