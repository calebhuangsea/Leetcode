package M311SparseMatrixMultiplication;

public class Solution {
    /**
     * Time: O(M*k*k*N)
     * Space: O(MN)
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat2[0].length];
        for (int k = 0; k < mat2.length; k++) {
            for (int i = 0; i < mat1.length; i++) {//rows of mat1
                if (mat1[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < mat2[0].length; j++) {// cols of mat2
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
}
