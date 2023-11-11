package M1197MinimumKnightMoves;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * Time: O(Max(|x|, |y|) ^2)
     * Space: O(Max(|x|, |y|) ^2)
     * @param x
     * @param y
     * @return
     */
    public int minKnightMoves(int x, int y) {
        // bfs
        int[][] offset = new int[][] {
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
                {1, -2}, {2, -1}, {2, 1}, {1, 2}
        };
        Deque<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[610][610];
        // offset = 305
        int step = 0;
        x += 305;
        y += 305;
        q.offer(new int[] {305, 305});
        visited[305][305] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                if (i == x && y == j) return step;
                for (int[] dir : offset) {
                    int xx = dir[0] + i;
                    int yy = dir[1] + j;
                    if (!visited[xx][yy]) {
                        visited[xx][yy] = true;
                        q.add(new int[]{xx,yy});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
