package Weekly370;
import java.util.*;
class Q4 {
    /**
     * Time: O(nlogn)
     * Space: O(n)
     * @param nums
     * @return
     */
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = nums[i] - i;
        }
        Arrays.sort(b);

        BIT t = new BIT(b.length + 1);
        for (int i = 0; i < n; i++) {
            // j 为 nums[i]-i 离散化后的值（从 1 开始）
            int j = Arrays.binarySearch(b, nums[i] - i) + 1;
            long f = Math.max(t.preMax(j), 0) + nums[i];
            t.update(j, f);
        }
        return t.preMax(b.length);
    }
}

// 树状数组模板（维护前缀最大值）
class BIT {
    private long[] tree;

    public BIT(int n) {
        tree = new long[n];
        Arrays.fill(tree, Long.MIN_VALUE);
    }

    public void update(int i, long val) {
        while (i < tree.length) {
            tree[i] = Math.max(tree[i], val);
            i += i & -i;
        }
    }

    public long preMax(int i) {
        long res = Long.MIN_VALUE;
        while (i > 0) {
            res = Math.max(res, tree[i]);
            i &= i - 1;
        }
        return res;
    }
}
