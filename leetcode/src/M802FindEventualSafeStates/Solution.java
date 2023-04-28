package M802FindEventualSafeStates;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(V+E)
     * Space: O(V)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ls = new ArrayList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, color)) {
                ls.add(i);
            }
        }
        return ls;
    }

    private boolean dfs(int curr, int[][] graph, int[] color) {
        if (color[curr] != 0) {
            return color[curr] == 1;
        }
        color[curr] = 2;
        for (int neigh : graph[curr]) {
            if (!dfs(neigh, graph, color)) {
                return false;
            }
        }

        color[curr] = 1;
        return true;
    }
}
