package Biweekly101;

import java.util.*;
import java.util.Map;

public class Q3 {
    public long makeSubKSumEqual(int[] arr, int k) {
        int[] sum = new int[arr.length];
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            // add sum
            int lo = i - k + 1;
            int hi = i + k - 1;
            for (int j = lo; j <= hi; j++) {
                if (j < 0) {
                    sum[sum.length + j] += arr[i];
                } else if (j >= sum.length) {
                    sum[j - sum.length] += arr[i];
                } else {
                    sum[j] += arr[i];
                }
                average+=arr[i];
            }
        }
        if (average % k == 0) {
            average /= k;
        } else {
            average = average / k + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            // add sum
            int lo = i - k + 1;
            int hi = i + k - 1;
            for (int j = lo; j <= hi; j++) {
                if (j < 0) {
                    sum[sum.length + j] += arr[i];
                } else if (j >= sum.length) {
                    sum[j - sum.length] += arr[i];
                } else {
                    sum[j] += arr[i];
                }
            }
        }
        return 1;
    }
}
