package Weekly369;

public class Q2 {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        int c1 = 0, c2 = 0;
        for (int n : nums1) {
            s1 += n;
            c1 += n == 0 ? 1 : 0;
        }
        for (int n : nums2) {
            s2 += n;
            c2 += n == 0 ? 1 : 0;
        }
        // we don't care about upperbound anymore, only invalid situation is when one of them have no 0 and is smaller or equal to the other one
        if (c1 == 0 && c2 == 0) {
            return s1 == s2 ? s1 : -1;
        } else if (c1 == 0 && s1 < s2 + c2) {
            return -1;
        } else if (c2 == 0 && s2 < s1 + c1) {
            return -1;
        } else {
            return Math.max(s1 + c1, s2 + c2);
        }
    }
}
