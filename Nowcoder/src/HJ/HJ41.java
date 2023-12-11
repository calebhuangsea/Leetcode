package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(); // we have n farma
        int[] w = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) w[i] = in.nextInt();
        for (int i = 0; i < n; i++) q[i] = in.nextInt();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> ls = new ArrayList<>(set);
            for (int j = 1; j <= q[i]; j++) {
                for (int k : ls) set.add(k + j * w[i]);
            }
        }
        System.out.println(set.size());
    }
}
