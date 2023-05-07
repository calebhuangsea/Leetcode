package DIV4.R871;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int n = sc.nextInt();
            int max = 0;
            int curr = 0;
            int last = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 0) {
                    // check if there is a last
                    if (last < j) {
                        curr++;
                    } else {
                        curr = 1;
                        last = j;
                    }
                } else {
                    curr = 0;
                }
                max = Math.max(max, curr);
            }
            System.out.println(max);
        }
    }
}
