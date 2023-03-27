package H4MedianOfTwoSortedArrays;

public class Solution {
    /**
     * Find the cut index of nums1 and nums2 and get 2 value from 4
     * Time Complexity: O(log(m+n)) 2ms 100%
     * Space Complexity: O(1) 43.8MB 21.18%
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int lo = 0;
        int hi = m;
        int numLeft = (m + n + 1) / 2;
        while (lo < hi) {
            int m1 = lo + (hi - lo + 1) / 2; //right side of the nums1 cut[m1 - 1 | m1]
            int m2 = numLeft - m1; // [m2 - 1 | m2]
            if (nums1[m1 - 1] > nums2[m2]) {
                hi = m1 - 1;
            } else {
                lo = m1;
            }
        }
        int m1 = lo;
        int m2 = numLeft - m1;
        double l1 = m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
        double l2 = m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
        double r1 = m1 == m ? Integer.MAX_VALUE : nums1[m1];
        double r2 = m2 == n ? Integer.MAX_VALUE : nums2[m2];
        if ((m + n) %2 == 1) {
            return Math.max(l1, l2);
        } else{
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
    }


    /**
     * Find kth smallest and get the average
     * Time Complexity O(log(m + n)): 2ms 100%
     * Space Complexity O(1): 44.5MB 8%
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m1 = help(nums1, nums2, nums1.length, nums2.length, (nums1.length + nums2.length + 1) / 2);
//        int m2 = help(nums1, nums2, nums1.length, nums2.length, (nums1.length + nums2.length + 2) / 2);
//        return (m1 + m2) * 1.0 / 2;
//    }

//    public static int help(int[] a, int[] b, int al, int bl, int k) {
//        // make sure that a is the smaller array
//        if (al > bl) {
//            return help(b, a, bl, al, k);
//        }
//        // set up 4 boundary
//        int l1;
//        int l2;
//        int r1;
//        int r2;
//        // pick the lower bound of a, if we have enough element in b, then index can start from 0
//        int lo = Math.max(0, k - bl);
//        // pick the upper bound of a, k if we have enough element in a, otherwise k - bl
//        int hi = Math.min(k, al);
//
//        // do binary search on both array
//        while (lo <= hi) {
//            // find the separate line in one array and find one for the other array
//            // by subtracting, then we can maintain the invariant that the front part has
//            // k elements
//            int c1 = (lo + hi) >> 1;
//            int c2 = k - c1;
//
//            // calculate elements at 4 key location and we will check if they satisfy the return condition
//            if (c1 != 0) {
//                l1 = a[c1 - 1];
//            } else {
//                l1 = Integer.MIN_VALUE;
//            }
//            if (c2 != 0) {
//                l2 = b[c2 - 1];
//            } else {
//                l2 = Integer.MIN_VALUE;
//            }
//            if (c1 != al) {
//                r1 = a[c1];
//            } else {
//                r1 = Integer.MAX_VALUE;
//            }
//            if (c2 != bl) {
//                r2 = b[c2];
//            } else {
//                r2 = Integer.MAX_VALUE;
//            }
//
//            if (l1 <= r2 && l2 <= r1) {
//                // if satisfy(k smallest element on the left part, pick the largest one)
//                return Math.max(l1, l2);
//            } else if (l1 > r2) {
//                hi = c1 - 1;
//            } else {
//                lo = c1 + 1;
//            }
//        }
//        return 1;
//    }
}
