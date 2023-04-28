package M934ShortestBridge;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // find the first island and mark all its cells as visited
        boolean found = false;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j);
                    found = true;
                }
            }
        }

        // BFS to find the shortest path to the second island
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        visited[x][y] = true;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, boolean[][] visited, Deque<int[]> q, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[] {i, j});
        for (int[] dir : dirs) {
            dfs(grid, visited, q, i + dir[0], j + dir[1]);
        }
    }
}
