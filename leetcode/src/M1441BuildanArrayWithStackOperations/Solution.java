package M1441BuildanArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int curr = 1;
        for (int t : target) {
            while (t > curr) {
                ans.add("Push");
                ans.add("Pop");
                curr++;
            }
            ans.add("Push");
            curr++;
        }
        return ans;
    }
}
