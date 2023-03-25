package M300LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * DP
     * Time Complexity O(N^2) 80ms 26.17%
     * Space Complexity O(N) 42.1MB 57.76%
     */
//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int max = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    if (dp[j] + 1 > dp[i]) {
//                        dp[i] = dp[j] + 1;
//                        max = Math.max(dp[i], max);
//                    }
//                }
//            }
//        }
//        return max;
//    }

    /**
     * Keep inserting element into the arrayList
     * Time Complexity O(N^2) 8ms 77.11%
     * Space Complexity O(N) 41.7MB 87.96%
     */
//    public int lengthOfLIS(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        list.add(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > list.get(list.size() - 1)) {
//                list.add(nums[i]);
//            } else {
//                int j = 0;
//                while (nums[i] > list.get(j)) {
//                    j++;
//                }
//                list.set(j, nums[i]);
//            }
//        }
//        return list.size();
//    }

    /**
     * Keep inserting element into the arrayList, use binary search to improve
     * Time Complexity O(Nlog(N)) 7ms 79.5%
     * Space Complexity O(N) 41.7MB 81.12%
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int j = binarySearch(list, nums[i]);
                list.set(j, nums[i]);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> ls, int num) {
        int lo = 0;
        int hi = ls.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = ls.get(mid);
            if (curr == num) {
                return mid;
            } else if (curr > num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
