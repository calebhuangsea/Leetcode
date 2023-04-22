package DIV3.R863;

import java.util.Scanner;

public class BConveyorBelts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int m1 = x1;
            m1 = Math.min(m1, y1);
            m1 = Math.min(m1, m + 1 - y1);
            m1 = Math.min(m1, m + 1 - x1);
            int m2 = x2;
            m2 = Math.min(m2, y2);
            m2 = Math.min(m2, m + 1 - y2);
            m2 = Math.min(m2, m + 1 - x2);
            System.out.println(Math.abs(m1 - m2));
        }
    }
}
