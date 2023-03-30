package M845LongestMountainInArray;

public class Solution {
    /**
     * One pass two pointer examination
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 43.6MB 38.9%
     */
    public int longestMountain(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int lo = i - 1;
            int hi = i + 1;
            if (arr[lo] < arr[i] && arr[hi] < arr[i]) {
                int size = 3;
                for (int j = lo - 1; j >= 0; j--) {
                    if (arr[j] < arr[j + 1]) {
                        size++;
                    } else {
                        break;
                    }
                }
                for (int j = hi + 1; j < arr.length; j++) {
                    if (arr[j] < arr[j - 1]) {
                        size++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }
}
