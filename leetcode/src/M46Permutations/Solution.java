package M46Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     *  Backtracking
     *  Time Complexity: O(P(N, k)) 2ms 37.5%
     *  Space Complexity: O(N!) 43MB 22.42%
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int n : nums) {
            if (curr.contains(n)) {
                continue;
            }
            curr.add(n);
            dfs(res, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
