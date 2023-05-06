package DIV4.R859;

import java.util.Scanner;

public class APlusorMinus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a + b == c) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }
}
