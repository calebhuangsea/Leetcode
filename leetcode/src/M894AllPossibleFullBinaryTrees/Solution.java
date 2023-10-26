package M894AllPossibleFullBinaryTrees;

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
     * Time: O(2^(n / 2))
     * Space: O(2^(n / 2))
     */
//    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
//    public List<TreeNode> allPossibleFBT(int n) {
//        if (n % 2 == 0) {
//            return new ArrayList<>();
//        }
//        if (n == 1) {
//            return Arrays.asList(new TreeNode());
//        }
//        if (memo.containsKey(n)) {
//            return memo.get(n);
//        }
//        List<TreeNode> res = new ArrayList<>();
//        for (int i = 1; i < n; i += 2) {
//            List<TreeNode> left = allPossibleFBT(i);
//            List<TreeNode> right = allPossibleFBT(n - i - 1);
//            for (TreeNode l : left) {
//                for (TreeNode r : right) {
//                    res.add(new TreeNode(0, l, r));
//                }
//            }
//        }
//        memo.put(n, res);
//        return res;
//    }
}
