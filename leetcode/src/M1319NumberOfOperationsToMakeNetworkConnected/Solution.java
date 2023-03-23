package M1319NumberOfOperationsToMakeNetworkConnected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * check for edge cases, the minimum number of cables we need to connect: n - 1
     * Use an adjacency list to keep track of edges first,
     * Then use dfs to mark all visitable computers
     * Add a count to computer that we cannot visit
     *
     * Time Complexity: O(E + V): We visit all edges and vertices 30ms 20.34%
     * Space Complexity: O(E + V): 73.2MB 11.35%
     */
    public static boolean[] visited;
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }
        visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : connections) {
            // add in the map if one of them is not found
            map.computeIfAbsent(arr[0], k -> new ArrayList<Integer>()).add(arr[1]);
            map.computeIfAbsent(arr[1], k -> new ArrayList<Integer>()).add(arr[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(map, i);
            }
        }
        return count - 1; // One of the unvisited node is reachable
    }

    private void dfs(Map<Integer, List<Integer>> map, int i) {
        visited[i] = true;
        if (!map.containsKey(i)) {
            return;
        }
        for (int node : map.get(i)) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(map, node);
            }
        }
    }
}
