package H1548TheMostSimilarPathinaGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Time: O(N * V * E)
     * Space: O(N * V * E)
     */
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            if (!adj.containsKey(road[0])) {
                adj.put(road[0], new ArrayList<>());
            }
            if (!adj.containsKey(road[1])) {
                adj.put(road[1], new ArrayList<>());
            }
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        int[][] dp = new int[targetPath.length][n];
        for (int i = 0; i < n; i++) {
            if (targetPath[0].equals(names[i])) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < targetPath.length; i++) {
            // the ith city
            for (int j = 0; j < n; j++) {
                // for each node, find the smallest neighbor distance from last path
                int min = Integer.MAX_VALUE;
                for (int neigh : adj.get(j)) {
                    min = Math.min(min, dp[i - 1][neigh]);
                }
                dp[i][j] = min + ((names[j].equals(targetPath[i])) ? 0 : 1);
            }
        }

        // traverse back
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (dp[targetPath.length - 1][i] < dp[targetPath.length - 1][index]) {
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(index);
        for (int i = targetPath.length - 1; i > 0; i--) {

            List<Integer> integers = adj.get(index);
            int min = integers.get(0);
            for (int j = 1; j < integers.size(); j++) {
                if (dp[i - 1][integers.get(j)] < dp[i - 1][min]) {
                    min = integers.get(j);
                }
            }
            index = min;
            res.add(0, index);
        }
        return res;
    }
}
