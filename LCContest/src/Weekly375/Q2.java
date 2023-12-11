package Weekly375;
import java.util.*;
public class Q2 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for (int[] v : variables) {
            long a = v[0], b = v[1], c = v[2], m = v[3];
            // if ((pow(a, b) % 10)^ci) % mi == target
            if (powerModulo(powerModulo(a, b, 10), c, m) == target) {
                res.add(i);
            }
            i++;
        }
        return res;
    }

    public static long powerModulo(long a, long b, long mod) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result = (result * a) % mod;
        }
        return result;
    }
}
