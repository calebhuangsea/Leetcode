package M56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // Sort two array and do two pointers
    // Time Complexity O(Nlog(N)) 4ms 99.63%
    // Space Complexity O(N) 47.7MB 22.33%
    public int[][] merge(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> list = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < intervals.length) {
            if (j == intervals.length - 1 || start[j + 1] > end[j]) {
                list.add(new int[] {start[i], end[j]});
                i = j + 1;
            }
            j++;
        }
        return list.toArray(new int[list.size()][]);
    }

    // Sort 2-d array by start index
    // update two pointers, add into a list if we are out of a boundary
    // Time Complexity O(Nlog(N)) 9ms 52.82%
    // Space Complexity O(N) 47.2MB 70.78%
//    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
//        List<Integer> ls = new ArrayList<>();
//        int lo = intervals[0][0];
//        int hi = intervals[0][1];
//        for (int i = 1; i < intervals.length; i++) {
//            int start = intervals[i][0];
//            int end = intervals[i][1];
//            if (start <= hi) {
//                if (end > hi) {
//                    hi = end;
//                }
//            } else {
//                ls.add(lo);
//                ls.add(hi);
//                lo = start;
//                hi = end;
//            }
//        }
//        ls.add(lo);
//        ls.add(hi);
//        int[][] res = new int[ls.size() / 2][2];
//        for (int i = 0; i < res.length; i++) {
//            res[i][0] = ls.get(i * 2);
//            res[i][1] = ls.get(i * 2 + 1);
//        }
//        return res;
//    }
}
