package E94BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

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
     * Iteratively check left branch then go to the right(if we hit the end of left it will go back)
     * Time Complexity O(N + M) 0ms 100% we visited every node and edge
     * Space Complexity O(N) we use a stack and a list to store 40.8MB 29.13%
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> ls = new ArrayList<>();
//        while (root != null || stack.size() > 0) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            ls.add(root.val);
//            root = root.right;
//        }
//        return ls;
//    }

    /**
     * Recursion, pretty easy
     * Time Complexity O(N + M) 0ms 100% we visited every node and edge
     * Space Complexity O(N) 40.4MB 71.65%
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
        ls.add(node.val);
        if (node.right != null) {
            helper(node.right, ls);
        }
    }
}