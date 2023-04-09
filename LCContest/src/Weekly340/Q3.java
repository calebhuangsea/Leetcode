package Weekly340;
import java.util.*;
public class Q3 {
    /**
     * Time Complexity O(nlog(n) + nlog(Max(nums)))
     * Space Complexity O(1)
     */
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, left= 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int k = 0;
            for (int i = 1; i < n && k < p; ++i) {
                if (nums[i] - nums[i - 1] <= mid) {
                    k++;
                    i++;
                }
            }
            if (k >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
