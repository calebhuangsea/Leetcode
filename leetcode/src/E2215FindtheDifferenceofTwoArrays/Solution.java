package E2215FindtheDifferenceofTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * Time: O(M+N)
     * Space: O(M + N)
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        for (int n1 : nums1) {
            if (set2.contains(n1)) {
                set1.remove(n1);
                set2.remove(n1);
            }
        }
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;
    }
}
