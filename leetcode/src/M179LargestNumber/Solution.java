package M179LargestNumber;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(nlog(n))
     * Space: O(n)
     */
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }
        Arrays.sort(str, (a, b) -> ((b + a).compareTo(a + b)));
        if (str[0] == "0") {
            return "0";
        }
        String lar = "";
        for (String s : str) {
            lar += s;
        }
        return lar;
    }
}
