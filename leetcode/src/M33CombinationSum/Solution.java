package M33CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Recursion on every possible combination
     * Time Complexity O(N^2) 2ms 85.39%
     * Space Complexity O(1) 42.5MB 83.68%
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], curr);
            curr.remove(curr.size() - 1);
        }
    }
}
