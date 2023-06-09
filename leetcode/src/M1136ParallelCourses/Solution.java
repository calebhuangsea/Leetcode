package M1136ParallelCourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * Time: O(V+E)
     * Space: O(V+E)
     */
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adj = new ArrayList[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : relations) {
            adj[r[0]-1].add(r[1]-1);
            in[r[1]-1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int times = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            n -= q.size();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                for (int nei : adj[curr]) {
                    in[nei]--;
                    if (in[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
            times++;
        }
        return n == 0 ? times : -1;
    }
}
