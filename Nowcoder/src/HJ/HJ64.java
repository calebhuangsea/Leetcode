package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        char[] op = in.next().toCharArray();
        int curr = 1;
        int start = 1; // 1 + 3 = end
        for (char c : op) {
            if (c == 'U') {
                if (curr == start) {
                    if (n <= 4) {
                        curr = n;
                        continue;
                    }
                    // we need to switch pages
                    if (curr == 1) { // special when we need to go to the end
                        start = n - 3;
                        curr = n;
                    } else {
                        start -= 1;
                        curr -= 1;
                    }
                } else {
                    curr -= 1;
                }
            } else if (c == 'D') {
                if (n <= 4 && curr == n) {
                    curr = 1;
                    continue;
                }
                if (curr == start + 3) {
                    if (start + 3 == n) {
                        start = 1;
                        curr = 1;
                    } else {
                        start += 1;
                        curr += 1;
                    }
                } else {
                    curr += 1;
                }
            }
        }
        for (int i = 0; i < Math.min(n, 4); i++) {
            System.out.print(i + start + " ");
        }
        System.out.println("\n" + curr);
    }
}
