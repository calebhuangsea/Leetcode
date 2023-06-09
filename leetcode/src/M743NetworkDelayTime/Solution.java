package M743NetworkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Time: O(N + Elog(N))
     * Space: O(N)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            int source = t[0] - 1;
            int target = t[1] - 1;
            int cost = t[2];
            adj[source].add(new int[] {target, cost});
        }
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[k - 1] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (costs[a] - costs[b]));
        pq.add(k - 1);
        while (!pq.isEmpty()) {
            int node = pq.poll();
            visited[node] = true;
            for (int[] nei : adj[node]) {
                if (visited[nei[0]]) {
                    continue;
                }
                if (costs[node] + nei[1] < costs[nei[0]]) {
                    costs[nei[0]] = costs[node] + nei[1];
                    pq.add(nei[0]);
                }
            }
        }
        Arrays.sort(costs);
        return costs[n - 1] == Integer.MAX_VALUE ? -1 : costs[n - 1];
    }
}
