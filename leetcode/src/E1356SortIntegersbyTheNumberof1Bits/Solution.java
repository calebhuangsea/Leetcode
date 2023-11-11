package E1356SortIntegersbyTheNumberof1Bits;

public class Solution {
    /**
     * Time O(N^2 * L)
     * Space: O(1)
     */
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int ci = count(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                int cj = count(arr[j]);
                if (cj < ci || (cj == ci && arr[j] < arr[index])) {
                    ci = cj;
                    index = j;
                }
            }
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
        return arr;
    }

    private int count(int x) {
        int count = 0;
        while (x > 0) {
            count += x & 1;
            x /= 2;
        }
        return count;
    }
}
