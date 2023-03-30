package E350E349IntersectionofTwoArraysII;

import java.util.*;

public class Solution {
    /**
     * Sort and two pointers
     * Time Complexity O(MLog(M) + Nlog(N)) 2ms 95.68%
     * Space Complexity O(1) 42.6MB 57.98%
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * Use map and list to keep track
     * Time Complexity O(M + N) 2ms 95.68%
     * Space Complexity O(Min(M, N)) 43MB 21.34%
     */
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//        Map<Integer, Integer> map1 = new HashMap<>();
//        for (int n : nums1) {
//            map1.put(n, map1.getOrDefault(n, 0) + 1);
//        }
//        int k = 0;
//        for (int n : nums2) {
//            int count = map1.getOrDefault(n, 0);
//            if (count > 0) {
//                nums1[k++] = n;
//                map1.put(n, count - 1);
//            }
//        }
//        return Arrays.copyOfRange(nums1, 0, k);
//    }
}
