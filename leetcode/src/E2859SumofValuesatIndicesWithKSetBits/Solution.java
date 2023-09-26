package E2859SumofValuesatIndicesWithKSetBits;

import java.util.List;

public class Solution {
    /**
     * Time: O(N * log(N))
     * Space: O(1)
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bits(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    private int bits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
