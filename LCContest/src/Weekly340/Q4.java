package Weekly340;
import java.util.*;
public class Q4 {
    /**
     * Time Complexity O(mnlog(mn))
     * Space Complexity O(mn)
     */

    public static int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 1 && n == 1) {
            return 1;
        }
        int max = -1;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        int dist = 1;
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                int val = grid[i][j];
                for (int k = 1; k <= val; k++) {
                    if (j + k >= n) {
                        break;
                    }
                    if (i == m - 1 &&  j + k == n - 1) {
                        return dist + 1;
                    }
                    if (visited[i][j+k] == 0 && grid[i][j + k] != 0) {
                        visited[i][j+k] = 1;
                        q.add(new int[]{i, j+k});
                    }
                }
                for (int k = 1; k <= val; k++) {
                    if (i + k >= m) {
                        break;
                    }
                    if (i + k == m - 1 &&  j == n - 1) {
                        return dist + 1;
                    }
                    if (visited[i + k][j] != 1 && grid[i + k][j] != 0) {
                        visited[i+k][j] = 1;
                        q.add(new int[]{i+k, j});
                    }
                }
                size--;
            }
            dist++;
        }
        return -1;
    }
}
