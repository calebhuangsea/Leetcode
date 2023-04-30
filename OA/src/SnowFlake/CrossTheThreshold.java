package SnowFlake;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/thread-982991-1-1.html
 *
 */
public class CrossTheThreshold {
    public static void main(String[] args) {
        int[] arr = new int[] {4,8,7,1,2};
        System.out.println(getMaxBarrier(arr, 9));
    }
    public static int getMaxBarrier(int[] initialEnergy, int th) {
        Arrays.sort(initialEnergy);
        int sum = Arrays.stream(initialEnergy).sum();
        int barrier = 1;
        int lo=0;
        while (sum >= th) {
            int i = divisionFindIndex(initialEnergy, lo, barrier);
            lo = i;
            sum = 0;
            for (int j = i; j < initialEnergy.length; j++) {
                sum += initialEnergy[j] - barrier;
            }
            barrier++;
        }
        return barrier - 2;
    }

    /**
     * Calculate the index such that (index - 1) will be 0
     */
    private static int divisionFindIndex(int[] arr, int lo,  int x) {
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }







}
