package M173BinarySearchTreeIterator;

import M105ConstructBinaryTreeFromPreorderAndInorderTraversal.Solution;

import java.util.Stack;

/*
Iterative inorder search, use stack as iterator
Time Complexity O(N + M) for next, O(1) for has Next 19ms 37.94%
Space Complexity O(N) 46.9MB 14.2%
 */
public class BSTIterator {
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
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        findLeft(root);
    }

    private void findLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        findLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}
