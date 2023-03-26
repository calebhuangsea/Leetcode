package Weekly338;

import java.util.*;

public class Q6357 {
    // prefix sum and binary search to find the insert point, calculate left and right
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] ss = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ss[i + 1] += ss[i] + nums[i];
        }
        List<Long> r = new ArrayList<>();
        for (int q : queries) {
            int i = searchInsert(nums, q);
            r.add(((long)q * (long)i - ss[i]) + ss[n] - ss[i] - (long)q * (long)(n-i));
        }
        return r;
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int lo = 0;
        int hi = nums.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                while (nums[mid--] == target)
                    return mid + 1;
            } else if (nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
