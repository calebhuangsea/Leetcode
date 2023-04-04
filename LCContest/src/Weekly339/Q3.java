package Weekly339;

import java.util.Arrays;

public class Q3 {
    /**
     * Time Complexity O(N) 13ms 100%
     * Space Complexity O(1) 51.5MB 75%
     */
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        // give all to mice 2 first
        int sum = 0;
        int n = r1.length;
        for (int i = 0; i < n; i++) {
            sum += r2[i];
            r1[i] -= r2[i];
        }
        // r1[i] = r1[i] - r2[i]
        // r1 is the value we can get for eating r1[i] instead
        Arrays.sort(r1);
        // add the max difference value between r1 and r2
        for (int i = n - k; i < n; i++) {
            sum += r1[i];
        }
        return sum;
    }


}
