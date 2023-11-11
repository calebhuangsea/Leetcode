package H2262TotalAppealofAString;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(26)
     */
    public long appealSum(String s) {
        long ans = 0;
        long sum_g = 0;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int i2 = last[s.charAt(i) - 'a'];
            sum_g += i - i2;
            ans += sum_g;
            last[i2] = i;
        }
        return ans;
    }
}
