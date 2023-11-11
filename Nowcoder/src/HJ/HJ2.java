package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] arr = in.nextLine().toLowerCase().toCharArray();
        int count = 0;
        char target = in.next().toLowerCase().charAt(0);
        for (char c : arr) {
            if (c == target) count++;
        }
        System.out.println(count);
    }
}
