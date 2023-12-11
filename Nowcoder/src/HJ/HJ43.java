package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ43 {
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        List<int[]> curr = new ArrayList<>();
        curr.add(new int[] {0, 0});
        solve(arr, 0, 0, curr);

    }

    private static void solve(int[][] arr, int i, int j, List<int[]> curr) {
        if (flag) return;
        if (i == arr.length - 1 && j == arr[i].length - 1) {
            for (int[] a : curr) {
                System.out.println("(" + a[0]+","+a[1]+")");
            }
            flag = true;
            return;
        }
        // four directions
        // up
        if (i - 1 >= 0 && arr[i - 1][j] == 0) {
            arr[i-1][j] = 1;
            curr.add(new int[] {i - 1, j});
            solve(arr, i - 1, j, curr);
            curr.remove(curr.size() - 1);
            arr[i-1][j] = 0;
        }
        if (i + 1 < arr.length && arr[i + 1][j] == 0) {
            arr[i+1][j] = 1;
            curr.add(new int[] {i + 1, j});
            solve(arr, i + 1, j, curr);
            curr.remove(curr.size() - 1);
            arr[i+1][j] = 0;
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 0) {
            arr[i][j - 1] = 1;
            curr.add(new int[] {i, j - 1});
            solve(arr, i, j - 1, curr);
            curr.remove(curr.size() - 1);
            arr[i][j - 1] = 0;
        }
        if (j + 1 < arr[i].length && arr[i][j + 1] == 0) {
            arr[i][j+1] = 1;
            curr.add(new int[] {i, j + 1});
            solve(arr, i, j + 1, curr);
            curr.remove(curr.size() - 1);
            arr[i][j + 1] = 0;
        }
    }
}
