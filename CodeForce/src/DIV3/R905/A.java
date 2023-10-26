package DIV3.R905;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 0; t < times; t++) {
            String line = sc.next();
            int cursor = 1;
            int step = 0;
            for (int i = 0; i < line.length(); i++) {
                int nxt = line.charAt(i) - '0';
                if (nxt == cursor) {
                    step += 1;
                    continue;
                } else if (nxt == 0) {
                    step += 1 + 10 - cursor;
                } else if (cursor == 0) {
                    step += 1 + 10 - nxt;
                } else if (nxt > cursor) {
                    step += 1 + nxt - cursor;
                } else {
                    step += 1 + cursor - nxt;
                }
                cursor = nxt;
            }
            System.out.println(step);
        }
    }
}
