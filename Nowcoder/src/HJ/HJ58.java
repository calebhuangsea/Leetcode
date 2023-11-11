package HJ;

import java.util.Scanner;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt(), k = in.nextInt();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(in.nextInt());
        }
        Collections.sort(ls);
        for (int i = 0; i < k; i++) {
            System.out.print(ls.get(i) + " ");
        }
    }
}
