package weekly373;

public class Q1 {
    /**
     * We can iterate through each row, compare the original position and rotated position using MOD
     * Runtime: O(MN)
     * Space: O(1)
     */

    public boolean areSimilar(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            int kk = (k % mat[0].length);
            if (i % 2 == 0) kk = mat[i].length - (k % mat[0].length);
            for (int j = 0; j < mat[0].length - 1; j++) {
                if (mat[i][j] != mat[i][(j + kk) % mat[0].length]) {
                    return false;
                }
            }
        }
        return true;
    }
}
