package Weekly349;
import java.util.*;
public class Q4 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nums1[i] + nums2[i];
        }
        Arrays.sort(res);
        int[] q = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = queries[i][0];
        }

        return q;
    }
}
