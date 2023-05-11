package DIV3.R540;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 1700
 */
public class D2CoffeeandCourseworkHard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (sum < m) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr, Collections.reverseOrder());

            int lo = 1;
            int hi = arr.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                long mnum = calculateMax(arr, mid);
                if (mnum < m) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            System.out.println(hi);
        }
    }

    private static long calculateMax(Integer[] arr, int len) {
        long sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // see if we want to break
            int num = arr[i] - i / len;
            if (num <= 0) {
                break;
            }
            sum += num * 1l;
        }
        return sum;
    }
}
