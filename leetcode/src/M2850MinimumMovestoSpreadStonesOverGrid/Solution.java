package M2850MinimumMovestoSpreadStonesOverGrid;
import java.util.*;
public class Solution {
    /**
     * Time: O(MN * NM!)
     * Space: O(NM)
     */
        public int minimumMoves(int[][] g) {
            List<int[]> todo = new ArrayList<>();
            List<int[]> empty = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (g[i][j] == 0) {
                        empty.add(new int[] {i,j});
                    }
                    if (g[i][j] > 1) {
                        for (int k = 1; k < g[i][j]; k++) {
                            todo.add(new int[] {i,j});
                        }
                    }
                }
            }
            List<List<Integer>> p1 = new ArrayList<>();
            dfs(p1, new ArrayList<>(), new HashSet<>(), empty.size());
            int ans = 100;
            // [0123]
            for (List<Integer> p : p1) {
                int curr = 0;
                for (int i = 0; i < p.size(); i++) {
                    int[] m1 = todo.get(p.get(i));
                    int[] m2 = empty.get(i);
                    curr += Math.abs(m1[0] - m2[0]) + Math.abs(m1[1] - m2[1]);
                }
                ans = Math.min(ans, curr);
            }
            return ans;

        }

        private void dfs(List<List<Integer>> p, List<Integer> curr, Set<Integer> set, int n) {
            if (set.size() == n) {
                p.add(new ArrayList<>(curr));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    curr.add(i);
                    dfs(p, curr, set, n);
                    curr.remove(curr.size() - 1);
                    set.remove(i);
                }
            }
        }
}
