package Weekly369;

import java.util.Arrays;

public class Q1 {
    public int findKOr(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums[nums.length - 1];
        while (n > 0) {
            count++;
            n /= 2;
        }
        int res = 0;
        int i = 1;
        while (count-- > 0) {
            int c = 0;
            for (int nn : nums) {
                if ((nn & i) == i) c++;
            }
            if (c >= k) res += i;
            i <<= 1;
        }
        return res;
    }
}
