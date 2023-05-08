package DIV2.R872;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            String palindrome = sc.next();
            char[] arr = palindrome.toCharArray();
            boolean flag = true;
            char c1 = arr[0];
            for (char c : arr) {
                if (c != c1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            } else {
                System.out.println(arr.length - 1);
            }
        }
    }

    private static int check(char[] arr, int lo, int hi) {
        if (lo >= hi) {
            return -2;
        }
        if (arr[lo] != arr[hi]) {
            return hi - lo;
        }
        int max = -2;
        max = Math.max(check(arr, lo + 1, hi), max);
        max = Math.max(check(arr, lo, hi - 1), max);
        return max;
    }
}
