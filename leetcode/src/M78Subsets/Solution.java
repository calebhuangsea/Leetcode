package M78Subsets;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    /**
     * Backtracking without keeping track of size
     * Time Complexity O(N * 2^N) 2^N possibilities and N copies 1ms 55.53%
     * Space Complexity O(N) N copies of results 42.7MB 41.9%
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
