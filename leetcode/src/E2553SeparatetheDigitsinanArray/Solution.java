package E2553SeparatetheDigitsinanArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            char[] arr = (n + "").toCharArray();
            for (char c : arr) {
                list.add(c - '0');
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
