package M1283FindTheSmallestDivisorGivenAThreshold;

public class Solution {
    /**
     * Binary Search
     * Time Complexity O(log(N)) 15ms 70.11%
     * Space Complexity O(1) 47.1MB 40.14%
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1;
        for (int i : nums) {
            hi = Math.max(hi, i);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = calc(nums, mid);
            if (sum > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int calc(int[] nums, int d) {
        int sum = 0;
        for (int i : nums) {
            sum += i / d;
            if (i % d != 0) {
                sum++;
            }
        }
        return sum;
    }
}
