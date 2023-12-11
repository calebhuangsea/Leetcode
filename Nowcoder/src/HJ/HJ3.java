package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(in.nextInt());
        for (int i : set) System.out.println(i);
    }
}
