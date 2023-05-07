package DIV4.R871;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int z = 0; z < lines; z++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] > 0) {
                        max = Math.max(max, bfs(arr, n, m, i, j));
                    }
                }
            }
            System.out.println(max);
        }
    }

//    private static int dfs(int[][] arr, int n, int m, int i, int j) {
//        if (i < 0 || j < 0 || i == n || j == m || arr[i][j] == 0) {
//            return 0;
//        }
//        int sum = arr[i][j];
//        arr[i][j] = 0;
//        sum += dfs(arr, n, m, i + 1, j);
//        sum += dfs(arr, n, m, i - 1, j);
//        sum += dfs(arr, n, m, i, j + 1);
//        sum += dfs(arr, n, m, i, j - 1);
//
//        return sum;
//    }
    private static int bfs(int[][] arr, int n, int m, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        int sum = 0;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        arr[i][j] *= -1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            sum += Math.abs(arr[x][y]);
            for (int[] d : dir) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx < 0 || newx == n || newy < 0 || newy == m || arr[newx][newy] <= 0) {
                    continue;
                }
                arr[newx][newy] *= -1;
                q.add(new int[] {newx, newy});
            }
        }
        return sum;
    }
}
