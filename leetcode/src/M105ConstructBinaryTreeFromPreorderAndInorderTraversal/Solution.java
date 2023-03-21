package M105ConstructBinaryTreeFromPreorderAndInorderTraversal;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Use preorder to find the root index and binary traversal
     * Time Complexity O(M + N) 3ms 46.67%
     * Space Complexity O(1) 42.3MB 49.82%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode help(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // find the mid point
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = help(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = help(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}
