package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Set<Character> set = new HashSet<>();
        char[] s = in.next().toCharArray();
        for (char c : s) {
            set.add(c);
        }
        System.out.println(set.size());
    }
}
