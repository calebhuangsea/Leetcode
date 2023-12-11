package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        Integer head = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(head, null);
        for (int i = 0; i < n - 1; i++) {
            int to = in.nextInt(), from = in.nextInt();
            Integer tail = map.get(from);
            map.put(from, to);
            map.put(to, tail);
        }
        int rm = in.nextInt();

        while (head != null) {
            if (head != rm) System.out.print(head + " ");
            // if (map.get(head) == null) break;
            head = map.get(head);
        }
    }
}
