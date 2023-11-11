package M2265CountNodesEqualtoAverageofSubtree;

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
     * Time: O(N)
     * Space: O(N)
     * @param root
     * @return
     */
//    int res = 0;
//    public int averageOfSubtree(TreeNode root) {
//        dfs(root);
//        return res;
//    }
//
//    private int[] dfs(TreeNode node) {
//        if (node == null) return new int[] {0,0};
//        int[] l = dfs(node.left);
//        int[] r = dfs(node.right);
//        int sum = l[0] + r[0] + node.val;
//        int count = l[1] + r[1] + 1;
//        if (sum / count == node.val) {
//            res++;
//        }
//        return new int[] {sum, count};
//    }
}
