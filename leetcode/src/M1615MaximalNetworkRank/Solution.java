package M1615MaximalNetworkRank;

import java.util.ArrayList;
import java.util.List;

public class Solution {public int maximalNetworkRank(int n, int[][] roads) {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    List<Integer>[] adj = new ArrayList[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int[] r : roads) {
        adj[r[0]].add(r[1]);
        adj[r[1]].add(r[0]);
    }
    // iterate through every city and find the pair
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (adj[i].contains(j)) {
                max = Math.max(max, adj[i].size() + adj[j].size() - 1);
            } else {
                max = Math.max(max, adj[i].size() + adj[j].size());
            }
        }
    }
    return max;
}
}
