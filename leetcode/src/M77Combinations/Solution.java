package M77Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Backtracking for size k list
     * Time Complexity O(k * C(k, N)) 25ms 38%
     * Space Complexity O(C(k, N)) 43.8MB 55.54%
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int i, List<List<Integer>> res, List<Integer> curr) {
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j <= n; j++) {
            curr.add(j);
            dfs(n, k, j + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
