package SnowFlake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array arr[] consisting of N ranges of the form [L, R],
 * the task is to determine the size of the smallest set that contains at least 2 integers within each interval.
 * https://www.geeksforgeeks.org/minimum-set-size-for-covering-intervals/
 */
public class MinimumSetCoveringIntervals {
    public static int compare(List<Integer> a,
                              List<Integer> b)
    {
        if (a.get(1).equals(b.get(1))) {
            return a.get(0).compareTo(b.get(0));
        }
        else {
            return a.get(1).compareTo(b.get(1));
        }
    }

    public static int
    intersectionSizeTwo(List<List<Integer> > intervals)
    {
        int n = intervals.size();

        // Sort the array
        Collections.sort(intervals, MinimumSetCoveringIntervals::compare);
        List<Integer> res = new ArrayList<>();

        // Known two rightmost point
        // in the set/res
        res.add(intervals.get(0).get(1) - 1);
        res.add(intervals.get(0).get(1));

        for (int i = 1; i < n; i++) {

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // Means there is no common between
            // curr interval and intervals
            // before this
            if (start > res.get(res.size() - 1)) {
                res.add(end - 1);
                res.add(end);
            }

            // Atleast 1 value from current
            // interval matches with previous
            // sets just add 1 max value
            else if (start > res.get(res.size() - 2)) {
                res.add(end);
            }
        }
        return res.size();
    }

    // Driver Code
    public static void main(String[] args)
    {
        // ranges
        List<List<Integer> > range = Arrays.asList(
                Arrays.asList(3, 6), Arrays.asList(2, 4),
                Arrays.asList(0, 2), Arrays.asList(3, 7));

        // Function Call
        System.out.println(intersectionSizeTwo(range));
    }
}
