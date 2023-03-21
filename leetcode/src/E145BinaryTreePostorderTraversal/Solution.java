package E145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * Left Right Mid
     * Iterative
     * Time Complexity O(N + M) 1ms 23.85% we visited every node and edge
     * Space Complexity O(N) we use a stack and a list to store 41MB 23.57%
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList();
//        if(root == null)
//            return res;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode curr = stack.pop();
//            res.add(0, curr.val);
//            if(curr.left != null)
//                stack.push(curr.left);
//            if(curr.right != null)
//                stack.push(curr.right);
//        }
//        return res;
//    }
    /**
     * Recursion, pretty easy
     * Time Complexity O(N + M) 0ms 100% we visited every node and edge
     * Space Complexity O(N) 40.1MB 94.92%%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> ls = new ArrayList<>();
        helper(root, ls);
        return ls;
    }

    public void helper(TreeNode node, List<Integer> ls) {
        if (node.left != null) {
            helper(node.left, ls);
        }
        if (node.right != null) {
            helper(node.right, ls);
        }
        ls.add(node.val);
    }
}
