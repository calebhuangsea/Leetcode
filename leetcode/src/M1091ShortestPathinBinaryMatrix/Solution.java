package M1091ShortestPathinBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = n;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[] {0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return ans + 1;
                }
                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
