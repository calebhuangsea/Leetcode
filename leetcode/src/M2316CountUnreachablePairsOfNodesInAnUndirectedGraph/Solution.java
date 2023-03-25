package M2316CountUnreachablePairsOfNodesInAnUndirectedGraph;

import java.util.*;


public class Solution {
    /**
     * Adjacency List to track connected nodes
     * And use BFS to calculate reachable component
     * we multiply reachable number of nodes with difference of rest number of node and reachable number of node
     * to calculate and remove reachable number of node to avoid duplicate
     * Time Complexity (V + E) 158ms 19.92%
     * Space Complexity (V + E) 138MB 12.27%
     */
    public long countPairs(int n, int[][] edges) {
        long max = 0;
        long nodes = n;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] conn : edges) {
            if (!adj.containsKey(conn[0])) {
                adj.put(conn[0], new HashSet<>());
            }
            if (!adj.containsKey(conn[1])) {
                adj.put(conn[1], new HashSet<>());
            }
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Queue<Integer> q = new LinkedList<>();
                long count = 1;
                q.add(i);
                visit[i] = true;
                while (q.size() > 0) {
                    int curr = q.remove();
                    if (!adj.containsKey(curr)) {
                        continue;
                    }
                    for (int neigh : adj.get(curr)) {
                        if (!visit[neigh]) {
                            count++;
                            q.add(neigh);
                            visit[neigh] = true;
                        }
                    }
                }
                max += count * (nodes - count);
                nodes -= count;
            }

        }
        return max;
    }
}
