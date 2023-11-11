package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] s = in.nextLine().toCharArray();
        Arrays.sort(s);
        for (char c : s) System.out.print(c);
    }
}
