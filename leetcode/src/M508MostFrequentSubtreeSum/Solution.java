package M508MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Time: O(V+E)
     * Space:O(N)
     */
    Map<Integer, Integer> freq = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        find(root);
        List<Integer> ls = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            if (freq.get(key) == max) {
                ls.add(key);
            }
        }
        return ls.stream().mapToInt(i -> i).toArray();
    }

    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += find(root.left);
        sum += find(root.right);
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        max = Math.max(freq.get(sum), max);
        return sum;
    }

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
}
