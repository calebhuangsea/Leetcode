package M1654MinimumJumpstoReachHome;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /**
     * Time: O(a + b + x)
     * Space: O(a + b + x)
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Pair<Integer, Integer>> ban = new HashSet<>();
        int max = x + a + b; //upper bound
        for (int n : forbidden) {
            ban.add(new Pair(n, 0));
            ban.add(new Pair(n, 1));
            max = Math.max(max, n + a + b);
        }
        // dp[i][j]: minimum step to reach i where the step that reach i is back or not
        // visited
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> curr = q.poll();
                int index = curr.getKey();
                int state = curr.getValue();
                if (index == x) {
                    return step;
                }
                Pair<Integer, Integer> forward = new Pair(index + a, 0);
                if (index + a <= max && ban.add(forward)) {
                    q.add(forward);
                }
                if (state == 0) {
                    // last move is not back now we move back
                    Pair<Integer, Integer> backward = new Pair(index - b, 1);
                    if (index - b >= 0 && ban.add(backward)) {
                        q.add(backward);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
