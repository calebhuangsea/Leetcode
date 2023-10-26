package DIV2.R904;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 0; t < times; t++) {
            int x = sc.nextInt();
            int k = sc.nextInt();
            for (int i = x; i < Integer.MAX_VALUE; i++) {
                if (sum(i) % k == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static int sum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

