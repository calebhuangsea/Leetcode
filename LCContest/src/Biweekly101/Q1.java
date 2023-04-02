package Biweekly101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1 {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] arr = new int[10];
        for (int n : nums1) {
            arr[n]++;
        }
        int min = 100;
        for (int n2 : nums2) {
            for (int i = 1; i < 10; i++) {
                if (arr[i] > 0) {
                    if (i == n2) {
                        min = Math.min(min, i);
                    } else {
                        min = Math.min(min, i * 10 + n2);
                        min = Math.min(min, i + n2 * 10);
                    }
                }
            }
        }
        return min;
    }

}
