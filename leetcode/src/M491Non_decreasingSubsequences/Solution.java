package M491Non_decreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * Time O(N * 2^N)
     * Space O(N * 2^N)
     */
    Set<List<Integer>> ls = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return new ArrayList<>(ls);
    }

    private void dfs(int index, List<Integer> curr, int[] nums) {
        if (index == nums.length) {
            if (curr.size() >= 2) {
                ls.add(new ArrayList<>(curr));
            }
            return;
        }
        if (curr.size() == 0 || curr.get(curr.size() - 1) <= nums[index]) {
            curr.add(nums[index]);
            dfs(index + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
        dfs(index + 1, curr, nums);
    }
}
