package M40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * Sort and check previous index to avoid duplicating, same as combination sum
     * Time Complexity O(2^N) 4ms 58.98%
     * Space Complexity O(1) 42.7MB 64.28%
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], curr);
            curr.remove(curr.size() - 1);
        }
    }
}
