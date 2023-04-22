package DIV3.R863;

import java.util.Scanner;

public class AInsertDigit {
    //9876543210123456789
    //98765443210123456789
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        for (int i = 0; i < row; i++) {
            int len = sc.nextInt();
            int digit = sc.nextInt();
            String num = sc.next();
            boolean flag = true;
            for (int j = 0; j < len && flag; j++) {
                if (num.charAt(j) - '0' >= digit) {
                    System.out.print(num.charAt(j));
                } else {
                    System.out.print(digit);
                    System.out.println(num.substring(j));
                    flag = !flag;
                }
            }
            if (flag) {
                System.out.println(digit);
            }
        }
    }
}
