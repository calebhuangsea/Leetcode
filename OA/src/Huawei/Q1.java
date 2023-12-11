package Huawei;

import java.util.*;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Q1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        int k = in.nextInt();
        int max = 0;
        for (int i = 1; i < k; i++) {
            if (arr[max] < arr[i]) max = i;
        }
        System.out.print(max);
        for (int i = k; i < n; i++) {
            if (i - k >= max) {
                // need to find a new max
                max = i - k + 1;
                for (int j = i - k + 2; j <= i; j++) {
                    if (arr[max] < arr[j]) max = j;
                }
            } else if (arr[i] > arr[max]) max = i;
            System.out.print(" " + max);
        }
    }
}
