package E760FindAnagramMappings;

public class Solution {
    /**
     * Time: O(N^2)
     * Space: O(1)
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
