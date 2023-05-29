package M1059AllPathsfromSourceLeadtoDestination;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(M + N)
     * Space: O(M + N)
     */
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }
        int[] v = new int[n];
        return dfs(source, destination, adj, v);
    }

    private boolean dfs(int node, int end, List<Integer>[] adj, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] == 2;
        }
        if (adj[node].isEmpty()) {
            return node == end;
        }
        visited[node] = 1;
        for (int nei : adj[node]) {
            if (!dfs(nei, end, adj, visited)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}
