package M74SearchA2DMatrix;

public class Solution {
    /**
     * Binary Search
     * Time Complexity O(log(mn)) 0ms 100%
     * Space Complexity O(1) 41.9MB 73.47%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int lo = 0;
        int hi = matrix.length * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }
        return false;
    }
}
