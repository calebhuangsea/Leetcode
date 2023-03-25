package M307RangeSumQueryMutable;

/**
 * Use a interval summing to keep track additional block sum
 * Time Complexity: constructor O(N), update O(1), query O(sqrt(N)) 119ms 68.16%
 * Space Complexity: O(sqrt(N)) 76.2MB 16.91%
 */
//public class NumArray {
//    private int[] nums;
//    private int[] seg;
//    private int len;
//
//    public NumArray(int[] nums) {
//        double l = Math.sqrt(nums.length);
//        len = (int)Math.ceil(nums.length / l);
//        this.nums = nums;
//        seg = new int[len];
//        for (int i = 0; i < nums.length; i++) {
//            seg[i / len] += nums[i];
//        }
//    }
//
//    public void update(int index, int val) {
//        int i = index / len;
//        seg[i] = seg[i] - nums[index] + val;
//        nums[index] = val;
//    }
//
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        int lo = left / len;
//        int hi = right / len;
//        if (lo == hi) {
//            for (int i = left; i <= right; i++) {
//                sum += nums[i];
//            }
//        } else {
//            for (int i = left; i < len * (lo + 1); i++) {
//                sum += nums[i];
//            }
//            for (int i = lo + 1; i < hi; i++) {
//                sum += seg[i];
//            }
//            for (int i = hi * len; i <= right; i++) {
//                sum += nums[i];
//            }
//        }
//        return sum;
//    }
//}

/**
 * Binary Segmentation tree
 * Time Complexity O(N) 137ms 33.51%
 * Space Complexity O(N) 74MB 39.87%
 */
class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;
            if (index % 2 == 0) {
                right++;
            } else {
                left--;
            }
            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;
        int sum = 0;
        while (left <= right) {
            // if left is the right child, that means we need to add the right child and ignore the left child
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }
            // if right is the left child, that means we need to add the left child and ignore the right child
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

