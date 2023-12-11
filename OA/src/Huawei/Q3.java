package Huawei;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int lo = 10;  // 区间下限
        int hi = 10;  // 区间上限
        int[] nums = {2, 3, 5};  // 可以使用的数字

        int result = countCombinations(lo, hi, nums);
        System.out.println("Total combinations: " + result);
    }

    private static int countCombinations(int lo, int hi, int[] nums) {
        int[] dp = new int[hi + 1];
        dp[0] = 1; // 达到总和为0的方法只有一种：不选择任何数字

        for (int num : nums) {
            for (int i = num; i <= hi; i++) {
                dp[i] += dp[i - num];
            }
        }

        int totalCount = 0;
        for (int i = lo; i <= hi; i++) {
            totalCount += dp[i];
        }

        return totalCount;
    }
}
