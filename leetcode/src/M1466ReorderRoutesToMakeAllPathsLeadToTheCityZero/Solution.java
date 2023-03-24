package M1466ReorderRoutesToMakeAllPathsLeadToTheCityZero;

import java.util.*;

public class Solution {
    /**
     * Use bfs adjacency list to keep track of the relation
     * We re-build the graph into an undirected graph and note extra edges we add in the adjacency list
     * Time Complexity O(V + E) 108ms 51.2%, we visit all edges and nodes
     * Space Complexity O(V + E) 74.3MB 46%, same as above
     *
     * Same as DFS, it is just the iteration step different
     */
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] conn : connections) {
            if (!adj.containsKey(conn[0])) {
                adj.put(conn[0], new ArrayList<>());
            }
            if (!adj.containsKey(conn[1])) {
                adj.put(conn[1], new ArrayList<>());
            }
            adj.get(conn[0]).add(new int[]{conn[1], 1});
            adj.get(conn[1]).add(new int[]{conn[0], 0});
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        int count = 0;
        while (q.size() > 0) {
            int curr = q.remove();
            List<int[]> neighbor = adj.get(curr);
            for (int[] neigh : neighbor) {
                if (!visited.contains(neigh[0])) {
                    visited.add(neigh[0]);
                    q.add(neigh[0]);
                    if (neigh[1] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
