package E228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        } else if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                // two cases, only one number
                if (i - 1 == last) {
                    res.add(nums[last] + "");
                } else {
                    // multiple numbers
                    res.add(nums[last] + "->" + nums[i - 1]);
                }
                last = i;
            }
        }
        if (last == nums.length - 1) {
            res.add(nums[last] + "");
        } else {
            res.add(nums[last] + "->" + nums[nums.length - 1]);
        }
        return res;
    }

}
