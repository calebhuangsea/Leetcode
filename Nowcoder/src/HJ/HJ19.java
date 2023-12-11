package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> index = new HashMap<>();
        int i = 1;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String path = in.nextLine();
            String file = "";
            for (int j = path.length() - 1; j >= 0; j--) {
                if (path.charAt(j) == '\\') {
                    file = path.substring(j + 1);
                    // see if we need to truncate
                    String[] t = file.split(" ");
                    if (t[0].length() > 16) {
                        t[0] = t[0].substring(t[0].length() - 16);
                    }
                    file = t[0] + " " + t[1];
                    break;
                }
            }
            if (!map.containsKey(file)) {
                map.put(file, 1);
                index.put(i++, file);
            } else {
                map.put(file, map.get(file) + 1);
            }
        }
        for (int j = 8; j >= 1; j--) {
            if (i - j > 0) {
                String file = index.get(i - j);
                System.out.println(file + " " + map.get(file));
            }
        }
    }
}
