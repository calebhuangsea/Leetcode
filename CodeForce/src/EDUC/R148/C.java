package EDUC.R148;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int l = 0; l < lines; l++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int count = 1;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int flag = -1;
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i - 1] && (flag == 1 || flag == -1)) {
                    flag = 0;
                    count++;
                } else if (arr[i] < arr[i - 1] && (flag == 0 || flag == -1)) {
                    flag = 1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
