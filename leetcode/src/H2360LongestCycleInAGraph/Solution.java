package H2360LongestCycleInAGraph;
import java.util.*;

public class Solution {
    /**
     * Recursion and dfs, go through every edge to find the cycle
     * Time Complexity O(N) 41.35%
     * Space Complexity O(N) 85MB 35.87%
     */
    private int max = -1;

    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, 1);
                dfs(edges, visited, map, i);
            }
        }
        return max;
    }

    private void dfs(int[] edges, boolean[] visited, Map<Integer, Integer> map, int node) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            map.put(neighbor, map.get(node) + 1);
            dfs(edges, visited, map, neighbor);
        } else if (neighbor != -1 && map.containsKey(neighbor)) {
            max = Math.max(max, map.get(node) - map.get(neighbor) + 1);
        }
    }
}
