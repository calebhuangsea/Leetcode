package DIV3.R878;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int length = sc.nextInt();
            String msg = sc.next();
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (idx < length) {
                sb.append(msg.charAt(idx));
                idx = msg.indexOf(msg.charAt(idx), idx + 1) + 1;
            }
            System.out.println(sb.toString());

        }
    }
}
