package SnowFlake;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/thread-971845-1-1.html
 */
public class FootballScores {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3, 7, 8, 10, 11, 29, 31};
        int[] b = new int[] {2, 4};
        System.out.println(Arrays.toString(counts(a, b)));
    }
    // sort both array and use binary search on the first one, find the largest index such that A is smaller than B
    public static int[] counts(int[] a, int[] b) {
        Arrays.sort(a);
        int[] res = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            res[i] = search(a, b[i]);
        }
        return res;
    }

    public static int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (arr[m] <= target) {
                lo = m + 1;
            } else {
                hi = m;
            }
        }
        return lo;
    }
}
