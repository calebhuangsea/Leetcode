package M1535FindtheWinnerofanArrayGame;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param arr
     * @param k
     * @return
     */
    public int getWinner(int[] arr, int k) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(max, n);
        }
        int n1 = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int n2 = arr[i];
            if (n1 > n2) {
                count++;
            } else {
                count = 1;
                n1 = n2;
            }
            if (count == k || n1 == max) {
                return n1;
            }
        }
        return -1;
    }
}
