package M48RotateImage;

public class Solution {
    /**
     * Time: O(n^2 / 4)
     * Space: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // we need n / 2 rotations
        for (int i = 0; i < n/2; i++) {
            // how many for each layer
            for (int j = 0; j < n - 2 * i - 1; j++) {
                int temp = matrix[i][j + i];
                matrix[i][j + i] = matrix[n - j - 1 - i][i];
                matrix[n - j - 1 - i][i] = matrix[n - i - 1][n - 1 - j - i];
                matrix[n - i - 1][n - 1 - j - i] = matrix[i + j][n - i - 1];
                matrix[i + j][n - i - 1] = temp;
            }
        }
    }
}
