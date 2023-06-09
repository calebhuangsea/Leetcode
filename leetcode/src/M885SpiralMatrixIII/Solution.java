package M885SpiralMatrixIII;

public class Solution {
    /**
     * Time: O(4MN)
     * Space: O(1)
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int left = cStart - 1;
        int right = cStart + 1;
        int hi = rStart - 1;
        int lo = rStart + 1;
        int x = rStart;
        int y = cStart;
        int[][] res = new int[rows * cols][2];
        int dir = 1; // 1 ->, 2 down, 3, left, 4, up
        int last = 1;
        int time = 0;
        while (time < rows * cols) {
            if (last == dir && x >= 0 && x < rows && y >= 0 && y < cols) {
                res[time++] = new int[] {x, y};
            }
            if (dir == 1) {
                last = 1;
                if (y == right) {
                    right++;
                    dir = 2;
                } else {
                    y++;
                }
            } else if (dir == 2) {
                last = 2;
                if (x == lo) {
                    lo++;
                    dir = 3;
                } else {
                    x++;
                }
            } else if (dir == 3) {
                last = 3;
                if (y == left) {
                    left--;
                    dir = 4;
                } else {
                    y--;
                }
            } else {
                last = 4;
                if (x == hi) {
                    hi--;
                    dir = 1;
                } else {
                    x--;
                }
            }
        }
        return res;
    }
}
