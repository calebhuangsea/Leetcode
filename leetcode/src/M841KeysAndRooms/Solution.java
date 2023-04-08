package M841KeysAndRooms;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(N) 4ms 11.79%
     * Space Complexity O(N) 42.7MB 30.81%
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int room = q.remove();
            visited.add(room);
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    q.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
