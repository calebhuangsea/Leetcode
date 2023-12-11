package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ74 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        boolean flag = false;
        int count = 0;
        List<String> ls = new ArrayList<>();
        String curr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !flag) {
                ls.add(curr);
                curr = "";
            }
            else if (c == '\"') flag = !flag;
            else curr+=c;
        }
        ls.add(curr);
        System.out.println(ls.size());
        for (String ss : ls) {
            System.out.println(ss);
        }
    }
}
