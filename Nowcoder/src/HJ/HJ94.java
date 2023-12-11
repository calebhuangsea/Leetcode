package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            Map<String, Integer> map = new HashMap<>();
            List<String> ls = new ArrayList<>();
            int inv = 0;
            for (int i = 0; i < a; i++) {
                String name = in.next();
                map.put(name,0);
                ls.add(name);
            }
            int b = in.nextInt();
            for (int i = 0; i < b; i++) {
                String name = in.next();
                if (map.containsKey(name)) {
                    map.put(name,map.get(name) + 1);
                } else inv += 1;

            }
            for (String key : ls) {
                System.out.println(key + " : " + map.get(key));
            }
            System.out.println("Invalid : " + inv);
        }
    }
}
