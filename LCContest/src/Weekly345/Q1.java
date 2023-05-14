package Weekly345;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.circularGameLosers(5, 2);
    }

    public int[] circularGameLosers(int n, int k) {
        int[] count = new int[n];
        count[0] = 1;
        int index = 0;
        int times = 1;
        while (true) {
            index += times++ * k;
            index %= n;
            count[index]++;
            if (count[index] == 2) {
                break;
            }
        }
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                ls.add(i + 1);
            }
        }
        int[] res = new int[ls.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}
