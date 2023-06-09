package DIV3.R878;

import java.util.Scanner;

public class B {

    static long sum;
    static long[] arr = new long[] {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824,2147483648l};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            // no more than 30
            sum = 1;
            int n = scan.nextInt(), k = Math.min(30, scan.nextInt());

            dfs(0, 0, k, n, 0);
            System.out.println(sum);
        }
    }

    private static void dfs(long curr, int idx, int k, int n, long prev) {
        if (curr > n || idx > k) {
            return;
        }
        if (curr != prev) {
            sum++;
        }
        dfs(curr + arr[idx], idx + 1, k, n, curr);
        dfs(curr, idx + 1, k, n, curr);
    }
}
