package M515FindLargestValueinEachTreeRow;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * Time Complexity: O(n)
     * Space: O(n / 2)
     */
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> dq = new LinkedList<>();
//        if (root == null) {return res;}
//        dq.offer(root);
//        while (!dq.isEmpty()) {
//            int n = dq.size();
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                TreeNode node = dq.poll();
//                max = Math.max(node.val, max);
//                if (node.left != null) {
//                    dq.offer(node.left);
//                }
//                if (node.right != null) {
//                    dq.offer(node.right);
//                }
//            }
//            res.add(max);
//        }
//        return res;
//    }
}
