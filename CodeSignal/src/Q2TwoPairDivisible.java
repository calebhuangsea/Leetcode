import java.util.HashMap;
import java.util.Map;

public class Q2TwoPairDivisible {
    /**
     * Count all index i < j such that a[i] + a[j] is divisible by k
     * Time Complexity O(N)
     * Space Complexity O(k)
     */
    long solution(int[] a, int k) {
        long sum = 0;
        Map<Integer, Integer> mod = new HashMap<>();
        for (int n : a) {
            int m = n % k;
            int mm = (k - m) % k;
            if (mod.containsKey(mm)) {
                sum += mod.get(mm);
            }
            if (!mod.containsKey(m)) {
                mod.put(m, 0);
            }
            mod.put(m, mod.get(m) + 1);
        }
        return sum;
    }
}
