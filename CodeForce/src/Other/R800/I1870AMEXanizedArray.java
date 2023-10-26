package Other.R800;

import java.util.Scanner;

public class I1870AMEXanizedArray {
    /**
     * Time: O(nt)
     * Space: O(1)
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 1; t <= times; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            if (n < k || x + 1 < k) {
                System.out.println(-1);
                continue;
            }
            int sum = 0;
            if (x == k) {
                for (int i = 0; i < n; i++) {
                    sum += i >= k ? x - 1 : i;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    sum += i >= k ? x : i;
                }
            }
            System.out.println(sum);
        }
    }
}
