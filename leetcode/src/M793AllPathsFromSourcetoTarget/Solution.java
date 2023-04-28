package M793AllPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(2^N * N)
     * Space: O(N)
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> ls = new ArrayList<>();
        ls.add(0);
        dfs(ls, 0, graph);
        return res;
    }

    private void dfs(List<Integer> ls, int i, int[][] graph) {
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(ls));
            return;
        }

        for (int neigh : graph[i]) {
            ls.add(neigh);
            dfs(ls, neigh, graph);
            ls.remove(ls.size() - 1);
        }
    }
}
