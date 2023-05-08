package DIV2.R872;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n * m];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            // we want the top left to be minimum
            // and the second minimum should be for the longer one for n / m
            int n1 = 0;
            int m1 = 0;
            int sum = 0; // assume left corner is max
            int sum2 = 0; // assume left corner is smallest
            int max1 = arr[arr.length - 1];
            int max2 = arr[arr.length - 2];
            int min1 = arr[0];
            int min2 = arr[1];
            if (n >= m) {
                // row > cols
                n1 = max1 - min1;
                m1 = max1 - min2;
                sum += n1 * (n - 1) * m;
                sum += m1 * (m - 1);

                n1 = max1 - min1;
                m1 = max2 - min1;
                sum2 += n1 * (n - 1) * m;
                sum2 += m1 * (m - 1);
            } else {
                n1 = max1 - min2;
                m1 = max1 - min1;
                sum += n1 * (n - 1);
                sum += m1 * n * (m - 1);

                n1 = max2 - min1;
                m1 = max1 - min1;
                sum2 += n1 * (n - 1);
                sum2 += m1 * n * (m - 1);
            }
            System.out.println(Math.max(sum, sum2));
        }
    }
}
