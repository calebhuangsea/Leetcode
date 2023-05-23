package M2397MaximumRowsCoveredbyColumns;

public class Solution {
    /**
     * Time: O(MN * 2^N)
     * Space: O(M)
     */
    int max = 0;
    int[] maxs;
    public int maximumRows(int[][] matrix, int numSelect) {
        maxs = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int n : matrix[i]) {
                maxs[i]+=n;
            }
        }
        back(matrix, numSelect, new int[matrix.length], -1);
        return max;
    }

    private void back(int[][] m, int left, int[] count, int index) {
        if (left == 0) {
            int sum = 0;
            for (int i = 0; i < m.length; i++) {
                if (maxs[i] == 0 || count[i] == maxs[i]) {
                    sum++;
                }
            }
            max = Math.max(sum, max);
            return;
        }
        for (int i = 1; index + i + left <= m[0].length; i++) {
            // let's pick the next col
            for (int j = 0; j < m.length; j++) {
                count[j] += m[j][i + index] == 1 ? 1 : 0;
            }

            back(m, left - 1, count, index + i);

            for (int j = 0; j < m.length; j++) {
                count[j] -= m[j][i + index] == 1 ? 1 : 0;
            }
        }
    }
}
