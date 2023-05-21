package M785IsGraphBipartite;

import java.util.Stack;

public class Solution {
    /**
     * Time: O(M + N)
     * Space: O(N)
     */
    public boolean isBipartite(int[][] graph) {
        // No inter-level cycle
        // Do BFS
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 1;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == 0) {
                            stack.push(nei);
                            color[nei] = -1 * color[node];
                        } else if (color[nei] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
