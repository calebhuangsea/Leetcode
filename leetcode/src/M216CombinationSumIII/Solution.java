package M216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(k * C(9,k))
     * Space: O(k)
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, n, k, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int remain, int k, List<Integer> curr) {
        if (remain == 0 && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        } else if (remain < 0 || curr.size() == k) {
            return;
        }
        for (int i = idx; i < 9; i++) {
            curr.add(i + 1);
            dfs(i+1, remain - i - 1, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
