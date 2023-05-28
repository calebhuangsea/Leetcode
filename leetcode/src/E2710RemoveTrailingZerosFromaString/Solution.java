package E2710RemoveTrailingZerosFromaString;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public String removeTrailingZeros(String num) {
        int index = num.length() - 1;
        while (num.charAt(index) == '0') {
            index -= 1;
        }
        return num.substring(0, index + 1);
    }
}
