package M1291SequentialDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls = new ArrayList<>();
        // what is 10^n of low
        // what is 10^n of high
        int l = 1;
        int t = 1;
        while (true) {
            if (low / t == 0) break;
            l++;
            t *= 10;
        }
        l--;
        int r = 1;
        t = 1;
        while (true) {
            if (high / t == 0) break;
            r++;
            t *= 10;
        }
        r--;
        for (int i = l; i <= r; i++) {
            for (int j = 1; j + i <= 10; j++) {
                int temp = 0;
                for (int k = j; k < i + j; k++) {
                    temp = temp * 10 + k;
                }
                if (temp >= low && temp <= high) {
                    ls.add(temp);
                }
            }
        }
        return ls;
    }
}
