package E88MergeSodtedArray;

public class Solution {
    /**
     * Time Complexity O(m + n) 0ms 100%
     * Space Complexity O(1) 42.4MB 63.6%
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }
}
