package M2300SuccessfulPairsOfSpellsAndPotions;

import java.util.Arrays;

public class Solution {
    /**
     * Binary search on left insert position
     * Time Complexity O((S + P) * log(P)) 64ms 86.36%
     * Space Complexity O(S) 62.6MB 35.12%
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int maxPotion = potions[n - 1];
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            // minimum potion needed to success
            long minPotion = (long)Math.ceil(1.0 * success / spells[i]);
            // if it exceed maximum boundary, no matching
            if (minPotion > maxPotion) {
                res[i] = 0;
                continue;
            }
            // use binary search to find the left most index
            res[i] = n - search(potions, minPotion);
        }
        return res;
    }

    private int search(int[] arr, long target) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
