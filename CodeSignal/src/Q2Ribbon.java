import java.util.Arrays;

public class Q2Ribbon {
    int solution(int[] a, int k) {
        Arrays.sort(a);
        int lo = 1;
        int hi = a[a.length - 1];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            for (int n : a) {
                // System.out.println(max + " : " + n + " : " + sum);
                sum += n / mid;
                if (sum >= k) {
                    break;
                }
            }
            if (sum >= k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
}
