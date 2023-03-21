package E144BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * Recursion, mid, left, right
     * Time Complexity: O(M + N) 0ms 100%
     * Space Complexity: O(N) 40.7MB 37.66%
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ls = new ArrayList<>();
//        if (root != null) {
//            helper(root, ls);
//        }
//        return ls;
//    }
//
//    public void helper(TreeNode node, List<Integer> ls) {
//        ls.add(node.val);
//        if (node.left != null) {
//            helper(node.left, ls);
//        }
//        if (node.right != null) {
//            helper(node.right, ls);
//        }
//    }

    /**
     * iterative, add right then left, because we use stack so that left is poped first
     * Time Complexity: O(M + N) 0ms 100%
     * Space Complexity: O(N) 40.5MB 60.23%
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            if (node != null) {
                ls.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return ls;
    }
}
