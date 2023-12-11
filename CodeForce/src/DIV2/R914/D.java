package DIV2.R914;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[][] visited = new int[n][n];
            for (int[] v : visited) Arrays.fill(v, -1);
            for (int i= 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i= 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            // divide and conquer, divide into two halves, and then merge
            if (solve(a, b, 0, n - 1, visited) == 1) out.println("YES");
            else out.println("NO");
        }
        out.close();
    }

    private static int solve(int[] a, int[] b, int l, int r, int[][] dp) {
        if (dp[l][r] != -1) return dp[l][r];
        if (l == r) {
            if (a[l] == b[l]) return dp[l][r] = 1;
            else return dp[l][r] = 0;
        }
        // check if we can replace this range first
        int max1 = a[l], max2 = b[l];
        for (int i = l + 1; i <= r; i++) {
            max1 = Math.max(max1, a[i]);
            max2 = Math.max(max2, b[i]);
        }
        boolean c1 = true , c2 = true;
        for (int i = l; i <= r; i++) {
            if (b[i] != max1) c1 = false;
            if (a[i] != max2) c2 = false;
            if (!c1 && !c2) break;
        }
        if (c1 || c2) {
            dp[l][r] = 1;
            return 1;
        }
        // l to r inclusive
        for (int i = l; i < r; i++) {
            int sum = solve(a, b, l, i, dp) + solve(a, b, i + 1, r, dp);
            if (sum == 2) {
                return dp[l][r] = 1;
            }
        }
        return dp[l][r] = 0;
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

