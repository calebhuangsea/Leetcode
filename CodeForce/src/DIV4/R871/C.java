package DIV4.R871;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int k = 0; k < lines; k++) {
            int n = sc.nextInt();
            int extra = Integer.MAX_VALUE;
            int n1 = Integer.MAX_VALUE;
            int n2 = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                String s = sc.next();
                if (s.equals("11")) {
                    extra = Math.min(extra, m);
                }
                if (s.charAt(0) == '1') {
                    if (n1 == -1) {
                    }
                    n1 = Math.min(n1, m);
                }
                if (s.charAt(1) == '1') {
                    n2 = Math.min(n2, m);
                }
            }
            if (extra == Integer.MAX_VALUE && (n1 == Integer.MAX_VALUE || n2 == Integer.MAX_VALUE)) {
                System.out.println(-1);
            } else {
                System.out.println(Math.min(extra, n1 + n2));
            }
        }
    }
}
