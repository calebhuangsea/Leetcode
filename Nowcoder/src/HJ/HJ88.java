package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] tokens = in.nextLine().split("-");
        int c = compare(tokens[0].split(" "), tokens[1].split(" "));
        if (c > 0) {
            System.out.println(tokens[0]);
        } else if (c < 0) {
            System.out.println(tokens[1]);
        } else {
            System.out.println("ERROR");
        }
    }

    private static int compare(String[] a, String[] b) {
        Map<String, Integer> map = new HashMap<>();
        map.put("3", 1);
        map.put("4", 2);
        map.put("5", 3);
        map.put("6", 4);
        map.put("7", 5);
        map.put("8", 6);
        map.put("9", 7);
        map.put("10", 8);
        map.put("J", 9);
        map.put("Q", 10);
        map.put("K", 11);
        map.put("A", 12);
        map.put("2", 13);
        map.put("joker", 14);
        map.put("JOKER", 15);
        boolean ba = isBoom(a), bb = isBoom(b);
        // System.out.println(ba);
        // System.out.println(bb);
        if (ba && bb) { // both, compare
            if (a[0].equals("joker")) return 1;
            if (b[0].equals("joker")) return 1;
            return map.get(a[0]) - map.get(b[0]);
        } else if (ba) { // ba wins
            return 1;
        } else if (bb) {
            return -1;
        } else {
            if (a.length != b.length) return 0; // length not the same
            // System.out.println(map.get(a[0]) - map.get(b[0]));
            return map.get(a[0]) - map.get(b[0]);
        }
    }

    private static boolean isBoom(String[] a) {
        // System.out.println(a.length);
        if (a.length == 2 && a[0].equals("joker")) return true;
        else if (a.length == 4) {
            for (int i = 1; i < 4; i++) {
                if (!a[i].equals(a[0])) {
                    return false;
                };
            }
            return true;
        }
        // System.out.println(a.length);
        return false;
    }
}
