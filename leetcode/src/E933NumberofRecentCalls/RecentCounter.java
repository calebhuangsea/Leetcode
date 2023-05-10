package E933NumberofRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(N)
 * Space: O(N)
 */
public class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.poll();
        }
        q.add(t);
        return q.size();
    }
}
