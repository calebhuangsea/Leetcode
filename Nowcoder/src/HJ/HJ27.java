package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<String, List<String>> map = new HashMap<>();
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            String o = in.next();
            char[] s = o.toCharArray();
            Arrays.sort(s);
            String ss = new String(s);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<>());
            }
            map.get(ss).add(o);
        }
        String o = in.next();
        char[] s = o.toCharArray();
        int k = in.nextInt();
        Arrays.sort(s);
        String ss = new String(s);
        if (map.containsKey(ss)) {
            List<String> ls = map.get(ss);
            Collections.sort(ls);
            String target = "";
            int i = 1;
            int d = 0;
            for (String nei : ls) {
                if (nei.equals(o)) {
                    // System.out.println(1 + ":"+nei);
                    d++;
                }
                else {
                    if (i == k) {
                        // System.out.println(2 + ":"+nei);
                        target = nei;
                    }
                    i++;
                }
            }
            System.out.println(ls.size() - d);
            System.out.println(target);
        } else {
            System.out.println(0);
        }
    }
}
