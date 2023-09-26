package Weekly349;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q = new Q3();
        int[] nums = {20, 1, 15};
        System.out.println(q.minCost(nums, 5));
    }
    public long minCost(int[] A, int x) {
        int n = A.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] += 1L * i * x;
            int cur = A[i];
            for (int k = 0; k < n; k++) {
                cur = Math.min(cur, A[(i - k + n) % n]);
                res[k] += cur;
            }
        }

        long min_res = Long.MAX_VALUE;
        for (long element : res) {
            min_res = Math.min(min_res, element);
        }

        return min_res;
    }
}
