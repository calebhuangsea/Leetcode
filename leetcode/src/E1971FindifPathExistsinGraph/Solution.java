package E1971FindifPathExistsinGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * Time: O(M + N)
     * Space: O(M + N)
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        Set<Integer> v = new HashSet<>();
        return dfs(source, destination, adj, new HashSet<>());
    }

    private boolean dfs(int curr, int target, List<Integer>[] adj, Set<Integer> visited) {
        if (curr == target) {
            return true;
        }
        visited.add(curr);
        for (int nei : adj[curr]) {
            if (visited.contains(nei)) {
                continue;
            }
            if (dfs(nei, target, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
