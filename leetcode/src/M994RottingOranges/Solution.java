package M994RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * BFS
     * Time Complexity O(MN) 2ms 84.95%
     * Space Complexity O(MN) 41.9MB 66.89%
     */
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int times = 0;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            times = Math.max(times, curr[2]);
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && y >= 0 && y < n && x < m && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    q.add(new int[] {x, y, curr[2] + 1});
                    count--;
                }
            }
        }
        if (count != 0) {
            return -1;
        }
        return times;
    }
}
