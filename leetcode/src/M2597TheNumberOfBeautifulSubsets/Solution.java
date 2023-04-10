package M2597TheNumberOfBeautifulSubsets;
import java.util.*;
public class Solution {
    /**
     * Time Complexity O(2^n)
     * Space Complexity O(N)
     */
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        back(nums, 0, ls, new ArrayList<>(), k);
        return ls.size();
    }

    private void back(int[] nums, int i, List<List<Integer>> ls, List<Integer> curr, int k) {
        if (i == nums.length) {
            if (curr.size() != 0) {
                ls.add(new ArrayList<>(curr));
            }
            return;
        }
        if (!curr.contains(nums[i] - k)) {
            curr.add(nums[i]);
            back(nums, i + 1, ls, curr, k);
            curr.remove(curr.size() - 1);
        }
        back(nums, i + 1, ls, curr, k);
    }
}
