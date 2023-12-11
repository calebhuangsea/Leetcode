package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        int[][] a1 = new int[x][y];
        int[][] a2 = new int[y][z];
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a1[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < z; j++) {
                a2[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                // res[i][i] means ith  row multiply by jth col
                for (int k = 0; k < y; k++) {
                    res[i][j] += a1[i][k] * a2[k][j];
                }
            }
        }
        for (int[] a : res) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}