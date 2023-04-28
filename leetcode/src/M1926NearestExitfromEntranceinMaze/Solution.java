package M1926NearestExitfromEntranceinMaze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(max(m, n))
     */
    int m;
    int n;
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;
        while (q.size() != 0) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                for (int[] dir : dirs) {
                    int x = arr[0] + dir[0];
                    int y = arr[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    if (maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
                        return step;
                    }
                    maze[x][y] = '+';
                    q.add(new int[] {x, y});
                }
            }
        }
        return -1;
    }
}
