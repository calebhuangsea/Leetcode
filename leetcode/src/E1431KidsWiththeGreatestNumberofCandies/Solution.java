package E1431KidsWiththeGreatestNumberofCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extra) {
        int max = -1;
        for (int n : candies) {
            max = Math.max(n, max);
        }
        List<Boolean> ls = new ArrayList<>();
        for (int n : candies) {
            ls.add(n + extra >= max);
        }
        return ls;
    }
}
