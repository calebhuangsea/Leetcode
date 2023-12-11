package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext
        // 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String s = in.nextLine();
            Map<Integer, List<String>> map = new HashMap<>();
            int max = -1;
            int last = -1; // if last character is digit

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (last == -1) last = i;
                } else {
                    if (last != -1) {
                        int curr = i - last;
                        if (!map.containsKey(curr)) map.put(curr, new ArrayList<String>());
                        map.get(curr).add(s.substring(last, i));
                        max = Math.max(curr, max);
                        last = -1;
                    }
                }
            }
            if (last != -1) {
                int curr = s.length() - last;
                if (!map.containsKey(curr)) map.put(curr, new ArrayList<String>());
                map.get(curr).add(s.substring(last, s.length()));
                max = Math.max(curr, max);
                last = -1;
            }
            String res = "";
            for (String ss : map.get(max)) {
                res += ss;
            }

            System.out.println(res + "," + max);
        }

    }
}
