package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        int n = in.nextInt();
        // all 7's multipliers
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0 || (i + "").contains("7")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
