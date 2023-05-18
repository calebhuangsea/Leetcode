package M1572MinimumNumberofVerticestoReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // if n doesn't exist
        int[] deg = new int[n];
        for (List<Integer> edge : edges) {
            deg[edge.get(1)]++;
        }
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                ls.add(i);
            }
        }
        return ls;
    }
}
