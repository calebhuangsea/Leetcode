package E1502CanMakeArithmeticProgressionFromSequence;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(Nlog(N))
     * Space: O(1)
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
