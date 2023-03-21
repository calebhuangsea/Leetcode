package M2348NumberOfZeroFilledSubarray;

public class Solution {
    /**
     * Contiguous 0s are equals to the sum(sigma) of the number
     * Time Complexity: O(n) 4ms 57.99%
     * Space Complexity: O(1) 60.1MB 35.74%
     * @param nums
     * @return
     */
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                long count = 1;
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    count++;
                    i = j;
                    j++;
                }
                i++;
                sum += calc(count);
            }
        }
        return sum;
    }

    private long calc(long i) {
        long res = 0;
        for (int j = 1; j <= i; j++) {
            res += j;
        }
        return res;
    }

    /**
     * Use the sum formula
     * Time Complexity: O(n) 6ms 34.17%
     * Space Complexity: O(1) 59.6MB 72.41%
     */
//    public long zeroFilledSubarray(int[] nums) {
//        long ans = 0;
//        long cnt = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                cnt++;
//            } else {
//                ans += cnt * (cnt + 1) / 2;
//                cnt = 0;
//            }
//        }
//
//        ans += cnt * (cnt + 1) / 2;
//
//        return ans;
//    }
}
