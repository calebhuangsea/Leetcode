package M442FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * Time: O(Nlog(N))
     * Space: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                res.add(nums[i]);
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }
}
