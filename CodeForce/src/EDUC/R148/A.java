package EDUC.R148;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        for (int i = 0; i < lines; i++) {
            String pal = scanner.next();
            int lo = 0;
            int mid = pal.length() / 2;
            Set<Character> set = new HashSet<>();
            for (int j = lo; j < mid; j++) {
                set.add(pal.charAt(j));
            }
            if (set.size()> 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
