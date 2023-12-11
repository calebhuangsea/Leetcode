package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n1 = in.nextInt();
        Set<Integer> arr = new TreeSet<>();
        for (int i = 0; i < n1; i++) {
            arr.add(in.nextInt());
        }
        int n2 = in.nextInt();
        for (int i = 0; i < n2; i++) {
            arr.add(in.nextInt());
        }
        for (int i : arr) {
            System.out.print(i);
        }

    }
}