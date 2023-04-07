package M2607MakeK_SubarraySumsEqual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * arr[i] = arr[i + k], find gcd and add sum to median
     * Time Complexity O(N) 129ms 79.93%
     * Space Complexity O(1) 61MB 74.42%
     */

    public long makeSubKSumEqual(int[] arr, int k) {
        long res = 0;
        k = gcd(k, arr.length);
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j += k) {
                list.add(arr[j]);
            }
            Collections.sort(list);
            // 0 1 2 3
            // 0 1 2
            int median = list.get(list.size() / 2);
            for (int n : list) {
                res += Math.abs(median - n);
            }
        }
        return res;
    }
    private int gcd(int a, int b)
    {
        // stores minimum(a, b)
        int i;
        if (a < b)
            i = a;
        else
            i = b;

        // take a loop iterating through smaller number to 1
        for (i = i; i > 1; i--) {

            // check if the current value of i divides both
            // numbers with remainder 0 if yes, then i is
            // the GCD of a and b
            if (a % i == 0 && b % i == 0)
                return i;
        }

        // if there are no common factors for a and b other
        // than 1, then GCD of a and b is 1
        return 1;
    }
}
