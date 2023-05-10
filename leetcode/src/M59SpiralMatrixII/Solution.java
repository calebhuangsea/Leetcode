package M59SpiralMatrixII;

public class Solution {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int[][] generateMatrix(int n) {
        int count = 1;
        int[][] arr = new int[n][n];
        int dir = 1; // 1right, 2left, 3up, 4down
        int i = 0;
        int j = 0;
        boolean flag = true;
        while (count <= n * n) {
            if (flag) {
                arr[i][j] = count++;
            }
            if (dir == 1) {
                if (j + 1 == n || arr[i][j + 1] != 0) {
                    dir = 4;
                    flag = false;
                } else {
                    j = j + 1;
                    flag = true;
                }
            }
            else if (dir == 2) {
                if (j - 1 < 0 || arr[i][j - 1] != 0) {
                    dir = 3;
                    flag = false;
                } else {
                    j -= 1;
                    flag = true;
                }
            }
            else if (dir == 3) {
                if (i - 1 < 0 || arr[i - 1][j] != 0) {
                    dir = 1;
                    flag = false;
                } else {
                    i -= 1;
                    flag = true;
                }
            }
            else if (dir == 4) {
                if (i + 1 == n || arr[i + 1][j] != 0) {
                    dir = 2;
                    flag = false;
                } else {
                    i += 1;
                    flag = true;
                }
            }
        }
        return arr;
    }
}
