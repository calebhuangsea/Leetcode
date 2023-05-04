package Biweekly103;

import java.lang.reflect.Array;
import java.util.*;

public class Q4 {
    /**
     * Time: O(Nlog(N))
     * Space: O(N)
     */
    class Solution {
        /**
         * Solution 1
         */
//        public long countOperationsToEmptyArray(int[] nums) {
//            int n = nums.length;
//            var id = new Integer[n];
//            for (int i = 0; i < n; ++i)
//                id[i] = i;
//            Arrays.sort(id, (i, j) -> nums[i] - nums[j]);
//
//            long ans = n; // 先把 n 计入答案
//            for (int k = 1; k < n; ++k)
//                if (id[k] < id[k - 1]) // 必须多走一整圈
//                    ans += n - k; // 减去前面删除的元素个数
//            return ans;
//        }

        public long countOperationsToEmptyArray(int[] nums) {
            int n = nums.length;
            var id = new Integer[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
            Arrays.sort(id, (i, j) -> nums[i] - nums[j]);

            long ans = n; // 先把 n 计入答案
            var t = new BIT(n + 1); // 下标从 1 开始
            int pre = 1; // 上一个最小值的位置，初始为 1
            for (int k = 0; k < n; ++k) {
                int i = id[k] + 1; // 下标从 1 开始
                if (i >= pre) // 从 pre 移动到 i，跳过已经删除的数
                    ans += i - pre - t.query(pre, i);
                else // 从 pre 移动到 n，再从 1 移动到 i，跳过已经删除的数
                    ans += n - pre + i - k + t.query(i, pre - 1);
                t.inc(i); // 删除 i
                pre = i;
            }
            return ans;
        }


        class BIT {
            private final int[] tree;

            public BIT(int n) {
                tree = new int[n];
            }

            public void inc(int i) {
                while (i < tree.length) {
                    ++tree[i];
                    i += i & -i;
                }
            }

            public int sum(int x) {
                int res = 0;
                while (x > 0) {
                    res += tree[x];
                    x &= x - 1;
                }
                return res;
            }

            public int query(int left, int right) {
                return sum(right) - sum(left - 1);
            }
        }
    }
}
