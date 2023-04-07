package M505TheMazeII;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(M * N MAX(M, N)) 7ms 91.54%
     * Space Complexity O(M * N) 43.9MB 12.8%
     */
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] dist : distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[curr[0]][curr[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[curr[0]][curr[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
