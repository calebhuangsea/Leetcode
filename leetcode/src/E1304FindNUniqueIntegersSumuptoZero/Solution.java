package E1304FindNUniqueIntegersSumuptoZero;

public class Solution {
    /**
     * Time: O(N / 2)
     * Space: O(N)
     */
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n / 2; i++) {
            arr[i * 2] = i + 1;
            arr[i * 2 + 1] = -(i + 1);
        }
        if (n % 2 != 0) {
            arr[n - 1] = 0;
        }
        return arr;
    }
}
