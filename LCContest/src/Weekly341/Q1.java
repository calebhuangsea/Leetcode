package Weekly341;

public class Q1 {
    /**
     * [Easy to Understand] Java Solution
     * Iterate through and keep track of each row's count and compare it to the max index and count
     *
     * O(MN)
     * O(1)
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int n : mat[i]) {
                count += n;
            }
            if (max < count) {
                max = count;
                index = i;
            }
        }
        return new int[] {index, max};
    }
}
