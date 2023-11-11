package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                int v = in.nextInt();
                map.put(key, map.getOrDefault(key, 0) + v);
            }
            for (int k : map.keySet()) {
                System.out.println(k + " " + map.get(k));
            }
        }
    }
}