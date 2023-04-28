package M547NumberofProvinces;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int index, int[][] conn, Set<Integer> visited) {
        for (int i = 0; i < conn.length; i++) {
            if ((conn[index][i] == 1 || conn[i][index] == 1) && !visited.contains(i)) {
                visited.add(i);
                dfs(i, conn, visited);
            }
        }
    }
}
