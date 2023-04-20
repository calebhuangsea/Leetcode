package M54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        char dir = 'r'; // left, right, up, down
        int i = 0;
        int j = 0;
        while (true) {
            res.add(arr[i][j]);
            arr[i][j] = 101;
            if (res.size() == m * n) {
                return res;
            }
            if (dir == 'l') {
                if (j - 1 >= 0 && arr[i][j - 1] <= 100) {
                    j--;
                } else {
                    i--;
                    dir = 'u';
                }
            } else if (dir == 'r') {
                if (j + 1 < n && arr[i][j + 1] <= 100) {
                    j++;
                } else {
                    i++;
                    dir = 'd';
                }
            } else if (dir == 'u') {
                if (i - 1 >= 0 && arr[i - 1][j] <= 100) {
                    i--;
                } else {
                    dir = 'r';
                    j++;
                }
            } else if (dir == 'd') {
                if (i + 1 < m && arr[i + 1][j] <= 100) {
                    i++;
                } else {
                    dir = 'l';
                    j--;
                }
            }
        }
    }
}
