package M90SubsetsII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    /**
     * Sort, Backtracking without keeping track of size, check for possible duplicates
     * Time Complexity O(N * 2^N) 2^N possibilities and N copies 1ms 55.53%
     * Space Complexity O(N) N copies of results 42.7MB 41.9%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            dfs(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
