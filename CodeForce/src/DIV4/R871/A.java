package DIV4.R871;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        String compare = "codeforces";
        for (int i = 0; i < lines; i++) {
            String s = sc.next();
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (s.charAt(j) != compare.charAt(j)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
