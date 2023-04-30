package Biweekly103;

import java.lang.reflect.Array;
import java.util.*;

public class Q4 {
    public long countOperationsToEmptyArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long sol = 0;
        int lo = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int key : map.keySet()) {
            // then we do operation on everything
            int index = map.get(key);
            sol += index - lo + 1;
            sol += index;
            if (index == n - 1) {
                lo = 0;
            } else {
                lo = index;
            }
        }
        return sol;
    }
}
