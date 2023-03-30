package E349IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Simply Two Set
     * Time Complexity O(N + M) 2ms 96.87%
     * Space Complexity O(N + M) 42.4MB 78.22%
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                set2.add(n);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
            res[i++] = n;
        }
        return res;
    }
}
