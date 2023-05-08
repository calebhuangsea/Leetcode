package E1572MatrixDiagonalSum;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[n - 1 - i][i];
            if (i == n - 1 - i) {
                sum -= mat[n - 1 - i][i];
            }
        }
        return sum;
    }
}
