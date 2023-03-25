package M2554MaximumNumberOfIntegersToChooseFromARangeI;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(NlogN): 59ms 55.23%
     * Space Complexity O(1): 44.7MB 12.67%
     * index and loop to keep track of duplicate banned number
     */
//    public int maxCount(int[] banned, int n, int maxSum) {
//        int sum = 0;
//        int count = 0;
//        int bIndex = 0;
//        Arrays.sort(banned);
//        for (int i = 1; i <= n; i++) {
//            if (bIndex < banned.length && i == banned[bIndex]) {
//                bIndex++;
//                while (bIndex < banned.length && banned[bIndex] == banned[bIndex - 1]) {
//                    bIndex ++;
//                }
//                continue;
//            }
//            if (sum + i > maxSum) {
//                break;
//            }
//            sum += i;
//            count++;
//        }
//        return count;
//    }

    /**
     * Set to detech banned number
     * Time Complexity O(N): 62ms 43.78%
     * Space Complexity O(N): 44.4MB 28.96%
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
