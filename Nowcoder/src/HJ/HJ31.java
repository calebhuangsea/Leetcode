package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        Stack<String> stack = new Stack<>();
        String curr = "";
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                // System.out.print("here1: " + c);
                curr += c;
            } else {
                // System.out.print("here2: " + curr);
                if (curr.length() != 0) stack.add(curr);
                curr = "";
            }
        }
        if (curr.length() != 0) stack.add(curr);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
