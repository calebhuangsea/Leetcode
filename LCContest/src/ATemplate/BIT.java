package ATemplate;

import java.util.Arrays;

// 树状数组模版 (维护前缀最大值）
class BIT {
    private long[] tree;

    public BIT(int n) {
        tree = new long[n];
        Arrays.fill(tree, Long.MIN_VALUE);
    }
    public void update(int i, long val) {
        // 把i往上的所有父区间都赋值
        // x + lowbit(x) = parent(x)
        while (i < tree.length) {
            tree[i] = Math.max(tree[i], val); // 前缀和改为加号即可
            i += i & -i; // calculate lowbit of index i
        }
    }

    public long preMax(int i) {
        long res = Long.MIN_VALUE;
        while (i > 0) {
            res = Math.max(res, tree[i]);
            // 每次把i更新成比i小的下一个inverval
            i &= i - 1;
        }
        return res;
    }
}