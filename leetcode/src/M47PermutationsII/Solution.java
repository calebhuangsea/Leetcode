package M47PermutationsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Use a map to deal with duplicate input and use backtracking
     * Time Complexity O(P(N, K)) 4ms 43.59%
     * Space Complexity O(N!) 43.3MB 44.3%
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        dfs(res, nums.length, map, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int len, Map<Integer, Integer> map, List<Integer> curr) {
        if (curr.size() == len) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count == 0) {
                continue;
            }
            curr.add(key);
            map.put(key, count - 1);
            dfs(res, len, map, curr);
            map.put(key, count);
            curr.remove(curr.size() - 1);
        }
    }
}
