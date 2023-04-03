package H85MaximalRectangle;

import java.util.Arrays;

public class Solution {
    /**
     * DP hard...
     * Time Complexity O(MN) 3ms 100%
     * Space Complexity O(N) 47.6MB 14.41%
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] l = new int[n];
        int[] h = new int[n];
        int[] r = new int[n];
        Arrays.fill(r, n);
        int max = 0;
        // level by level
        for (int i = 0; i < m; i++) {
            // calculate height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    h[j]++;
                } else {
                    h[j] = 0;
                }
            }
            int left = 0;
            int right = n;
            // calculate left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    l[j] = Math.max(l[j], left);
                } else {
                    l[j] = 0;
                    left = j + 1;
                }
            }
            // calculate right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    r[j] = Math.min(r[j], right);
                } else {
                    r[j] = n;
                    right = j;
                }
            }
            // calculate area
            for (int j = 0; j < n; j++) {
                max = Math.max(max, h[j] * (r[j] - l[j]));
            }
        }
        return max;
    }
}
