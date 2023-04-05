package M102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    class TreeNode {
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
     * BFS keeping track of level
     * Time Complexity O(V + E)
     * Space Complexity O(|V|)
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        if (root == null) {
//            return res;
//        }
//        q.add(root);
//        q.add(null);
//        int level = 0;
//        res.add(new ArrayList<>());
//        while (q.size() > 0) {
//            TreeNode curr = q.poll();
//            if (curr == null) {
//                level++;
//                res.add(new ArrayList<>());
//                continue;
//            }
//            res.get(level).add(curr.val);
//            if (curr.left != null) {
//                q.add(curr.left);
//            }
//            if (curr.right != null) {
//                q.add(curr.right);
//            }
//            if (q.size() > 0 && q.peek() == null) {
//                if (q.size() == 1) {
//                    break;
//                }
//                q.add(null);
//            }
//        }
//        return res;
//    }

    /**
     * DFS recursion
     * Time Complexity O(V + E)
     * Space Complexity O(|V|)
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    /**
     * DFS and reverse
     * Time Complexity O(V + E) 1ms 92.72%
     * Space Complexity O(V) 42.4MB 82.6%
     */
//    private List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//        helper(root, 0);
//        Collections.reverse(res);
//        return res;
//    }
//
//    private void helper(TreeNode root, int level) {
//        if (level == res.size()) {
//            res.add(new ArrayList<>());
//        }
//        res.get(level).add(root.val);
//        if (root.left != null) {
//            helper(root.left, level + 1);
//        }
//        if (root.right != null) {
//            helper(root.right, level + 1);
//        }
//    }
}
