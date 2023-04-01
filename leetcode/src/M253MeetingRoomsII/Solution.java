package M253MeetingRoomsII;

import java.util.Arrays;

public class Solution {
    /**
     * Sort and do two pointers
     * Time Complexity O(Nlog(N)) 3ms 98.43%
     * Space Complexity O(N) 42.9MB 23.82%
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int i = 0;
        int j = 0;

        // Whenever we have another room starting, we create an extra room
        // but if the start time is greater than one of the meeting, it means some previous meeting is ended
        while (i < intervals.length) {
            // check if we are having more intervals before this end time
            if (start[i] >= end[j]) {
                // we don't need to create new room
                rooms--;
                j++;
            }
            rooms++;
            i++;
        }
        return rooms;
    }


    /**
     * Use a table to count intervals
     * Time Complexity O(N): 354ms 5.17%
     * Space Complexity O(10^6): 50.3MB 5.4%
     */
//    public int minMeetingRooms(int[][] intervals) {
//        int[] table = new int[1000000];
//        int sum = 0;
//        for (int[] interval : intervals) {
//            for (int i = interval[0]; i < interval[1]; i++) {
//                table[i]++;
//                sum = Math.max(sum, table[i]);
//            }
//        }
//        return sum;
//    }
}
