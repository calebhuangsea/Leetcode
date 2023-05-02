package M1129ShortestPathwithAlternatingColors;

import java.util.*;

public class Solution {
    /**
     * Time: O(V + E)
     * Space: O(V)
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> red = new HashMap<>();
        Map<Integer, List<Integer>> blue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            red.put(i, new ArrayList<>());
            blue.put(i, new ArrayList<>());
        }
        for (int[] e : redEdges) {
            red.get(e[0]).add(e[1]);
        }
        for (int[] e : blueEdges) {
            blue.get(e[0]).add(e[1]);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        q.add(new int[] {0, 0, -1});// node, step, color(0 blue, 1 red)
        visited[0][0] = visited[0][1] = true;
        res[0] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int step = curr[1];
            int color = curr[2];
            if (res[node] == -1 || step < res[node]) {
                res[node] = step;
            }
            if (color != 0) {
                // if not blue
                for (int nei : blue.get(node)) {
                    if (visited[nei][0]) {
                        continue;
                    }
                    q.add(new int[] {nei, step + 1, 0});
                    visited[nei][0] = true;
                }
            }
            if (color != 1) {
                // if not red
                for (int nei : red.get(node)) {
                    if (visited[nei][1]) {
                        continue;
                    }
                    q.add(new int[] {nei, step + 1, 1});
                    visited[nei][1] = true;
                }
            }
        }
        return res;

    }
}
