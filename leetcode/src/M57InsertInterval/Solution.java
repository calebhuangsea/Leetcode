package M57InsertInterval;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * keep merging intervals and update the newInterval to the end
     * Time Complexity O(N) 1ms 98.76%
     * Space Complexity O(N) 44.8MB 48.66%
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            // if new interval appear before, insert the newinterval and update it to current interval
            if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                // if new interval appear after, do nothing and insert back current interval
                list.add(interval);
            } else {
                // if newinterval is in between, update new interval to merge two intervals
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
