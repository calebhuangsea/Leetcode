package M986IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Two pointers
     * Time Complexity O(M + N) 3ms 90.77%
     * Space Complexity O(1) 43.4MB 35.16%
     */
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < first.length && j < second.length) {
            // if interval i is not intersect and need to move on
            if (first[i][1] < second[j][0]) {
                i++;
            } else if (first[i][0] > second[j][1]) {
                // if interval j is not intersect and need to move on
                j++;
            } else {
                // intersection
                result.add(new int[] {Math.max(first[i][0], second[j][0]), Math.min(first[i][1], second[j][1])});
                if (first[i][1] < second[j][1]) {
                    i++;
                } else if (first[i][1] > second[j][1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }

        }
        return result.toArray(new int[result.size()][]);
    }
}
