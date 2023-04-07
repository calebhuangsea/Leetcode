package M542_01Matrix;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(M N) 15ms 49.1%
     * Space Complexity O(M N) 45.7MB 59.14%
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    q.add(new int[] {i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if (dist[x][y] > dist[curr[0]][curr[1]] + 1) {
                        dist[x][y] = dist[curr[0]][curr[1]] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
        return dist;
    }
}
