package Weekly341;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    /**
     * [Easy to Understand] Java Solution
     * Compare each num in nums to divisor and store the division score
     * At the keep track of maximum score (or minimum divisor break tie)
     * O(ND) N: nums.length, D: divisors.length
     * O(D)
     */
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0;
        int k = 0;
        int[] arr = new int[divisors.length];
        for (int n : nums) {
            for (int i = 0; i < divisors.length; i++) {
                if (n % divisors[i] == 0) {
                    arr[i]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                k = i;
            } else if (arr[i] == max && divisors[i] < divisors[k]) {
                k = i;
            }
        }
        return divisors[k];
    }
}
