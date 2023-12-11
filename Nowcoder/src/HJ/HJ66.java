package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ66 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[][] map = new String[5][3];
        map[0] = new String[] {"reset", "board", "board fault"};
        map[1] = new String[] {"board", "add", "where to add"};
        map[2] = new String[] {"board", "delete", "no board at all"};
        map[3] = new String[] {"reboot", "backplane", "impossible"};
        map[4] = new String[] {"backplane", "abort", "install first"};
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            if (s.length == 1) {
                if ("reset".indexOf(s[0]) == 0) System.out.println("reset what");
                else System.out.println("unknown command");
            } else if (s.length == 2) {
                List<Integer> ls = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    if (map[i][0].indexOf(s[0]) == 0) {
                        ls.add(i);
                    }
                }
                int i = -1;
                for (int index : ls) {
                    if (map[index][1].indexOf(s[1]) == 0) {
                        if (i == -1) i = index;
                        else {
                            i = -1;
                            break;
                        }
                    }
                }
                if (i == -1) System.out.println("unknown command");
                else System.out.println(map[i][2]);
            }
        }
    }
}
