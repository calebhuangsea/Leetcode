package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = in.next();
            int m = in.nextInt();
            Set<Integer> reg = new TreeSet<>();
            for (int i = 0; i < m; i++) reg.add(in.nextInt());
            List<String> res = new ArrayList<>();
            for (int r : reg) {
                List<String> sub = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].contains(r + "")) {
                        sub.add(i + "");
                        sub.add(arr[i]);
                    }
                }
                if (sub.size() != 0) {
                    res.add(r +"");
                    res.add(sub.size() / 2 + "");
                    for (String s : sub) res.add(s + "");
                }
            }
            System.out.print(res.size());
            for (String re : res) System.out.print(" " + re);

        }
    }
}