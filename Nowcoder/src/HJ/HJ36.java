package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String key = in.next();
        String content = in.next();
        Set<Character> set = new HashSet<>();
        char[] map = new char[26];
        int index = 0;
        for (char c : key.toCharArray()) {
            if (!set.contains(c)) {
                map[index++] = c;
            }
            set.add(c);
        }
        for (int i = 0; i < 26; i++) {
            char c =(char)(i + 'a');
            if (!set.contains(c)) {
                map[index++] = c;
            }
        }
        for (char c : content.toCharArray()) {
            System.out.print(map[c - 'a']);
        }
    }
}
