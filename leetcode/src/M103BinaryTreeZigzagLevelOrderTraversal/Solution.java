package M103BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

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
     * DFS recursion
     * Time Complexity O(V + E) 0ms 100%
     * Space Complexity O(|V|) 41.5MB 18.72%
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 != 0) {
            res.get(level).add(0, node.val);
        } else {
            res.get(level).add(node.val);
        }

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    /**
     * BFS iteratively keep track level
     * Time Complexity O(V + E) 1ms 77.63%
     * Space Complexity O(|V|) 42.6MB 5.78%
     */
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
//            if (level % 2 == 1) {
//                res.get(level).add(0, curr.val);
//            } else {
//                res.get(level).add(curr.val);
//            }
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
}
