package DIV3.R863;

import java.util.Scanner;
import java.util.Vector;

public class CRestoretheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int j = 0; j < times; j++) {
            int n = sc.nextInt();
            Vector<Integer> b = new Vector<>(n-1);
            Vector<Integer> a = new Vector<>();

            for (int i = 0; i < n - 1; i++) b.add(sc.nextInt());
            a.add(b.get(0));

            for (int i = 0; i < n - 2; i++) {
                a.add(Math.min(b.get(i), b.get(i + 1)));
            }
            a.add(b.get(n - 2));

            for (int i : a) System.out.print(i + " ");
            System.out.println();
        }
    }
}
