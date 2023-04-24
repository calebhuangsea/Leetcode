package M1162AsFarfromLandasPossible;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int distance = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                int[] curr = q.poll();
                for (int[] dir : direction) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x >= 0 && y >= 0 && x < n && y < n && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            distance++;
        }
        return distance == 0 ? -1 : distance;
    }
}
