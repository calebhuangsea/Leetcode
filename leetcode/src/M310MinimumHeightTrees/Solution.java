package M310MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * Time: O(V + E)
     * Space: O(V + E)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        // height : [roots]
        int[] in = new int[n];

        // find the height of every root: BFS
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            in[e[1]]++;
            in[e[0]]++;
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newL = new ArrayList<>();
            for (int i : leaves) {
                for (int nei : adj[i]) {
                    adj[nei].remove((Integer)i);
                    if (adj[nei].size() == 1) {
                        newL.add(nei);
                    }
                }
            }
            leaves = newL;
        }

        return leaves;
    }
}
