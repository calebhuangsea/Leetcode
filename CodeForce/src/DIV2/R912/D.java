package DIV2.R912;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: size of the array and the number of queries
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] count = new int[61];
        // Input: elements of the array
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }
        // pre process each k
        // Process each query
        for (int i = 0; i < q; i++) {
            long k = scanner.nextLong();
        }

        scanner.close();
    }

}

