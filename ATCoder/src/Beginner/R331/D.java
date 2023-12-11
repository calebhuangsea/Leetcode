package Beginner.R331;

import java.io.*;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), q = sc.nextInt();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'B') dp[i][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[0][i] += dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        for (int i = 0; i < q; i++) {
            int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            // ab left upper, cd right lower
            long sum = 0;
            // 9 areas
            // top left area
            // if we have left overflow
            int cdiff = c2 / n - c1 / n;
            int rdiff = r2 / n - r1 / n;
            if (cdiff == 0 && rdiff == 0) {
                // same box, just search
                sum += query(dp, r1 % n, c1 % n, r2 % n, c2 % n);
            }
            if (cdiff == 1 && rdiff == 1) {
                // 4 boxes
                sum += query(dp, r1 % n, c1 % n, n - 1, n - 1);
                sum += query(dp, r1 % n, 0, n - 1, c2 % n);
                sum += query(dp, 0, c1 % n, r2 % n, n - 1);
                sum += query(dp, 0, 0, r2 % n, c2 % n);
            }
            if (cdiff == 0 && rdiff >= 1) {
                // up and down and middle
                sum += query(dp, r1 % n, c1 % n, n - 1, c2 % n);
                sum += query(dp, 0, c1 % n, r2 % n, c2 % n);
                sum += query(dp, 0, 0, n - 1, n - 1) * (rdiff - 1);
            }
            if (cdiff >= 1 && rdiff == 0) {
                // left and right and middle
                sum += query(dp, r1 % n, c1 % n, r2 % n, n - 1);
                sum += query(dp, r1 % n, 0, r2 % n, c2 % n);
                sum += query(dp, 0, 0, n - 1, n - 1) * (cdiff - 1);
            }
            if (cdiff == 1 && rdiff > 1) {
                // 6 boxes
                sum += query(dp, r1 % n, c1 % n, n - 1, n - 1);
                sum += query(dp, r1 % n, 0, n - 1, c2 % n);
                sum += query(dp, 0, c1 % n, r2 % n, n - 1);
                sum += query(dp, 0, 0, r2 % n, c2 % n);
                sum += query(dp, 0, c1 % n, n - 1, n - 1) * (rdiff - 1);
                sum += query(dp, 0, 0, n - 1, c2 % n) * (rdiff - 1);
            }
            if (cdiff > 1 && rdiff == 1) {
                // 6 boxes
                sum += query(dp, r1 % n, c1 % n, n - 1, n - 1);
                sum += query(dp, 0, c1 % n, r2 % n, n - 1);
                sum += query(dp, r1 % n, 0, r2 % n, c2 % n);
                sum += query(dp, 0, 0, r2 % n, c2 % n);
                sum += query(dp, r1 % n, 0, n - 1, n - 1) * (cdiff - 1);
                sum += query(dp, 0, 0, r2 % n, n - 1) * (cdiff - 1);
            }
            if (cdiff > 1 && rdiff > 1) {
                // 9 boxes
                sum += query(dp, r1 % n, c1 % n, n - 1, n - 1);
                sum += query(dp, r1 % n, 0, n - 1, c2 % n);
                sum += query(dp, 0, c1 % n, r2 % n, n - 1);
                sum += query(dp, 0, 0, r2 % n, c2 % n);
                sum += query(dp, r1 % n, 0, n - 1, n - 1) * (cdiff - 1);
                sum += query(dp, 0, c1 % n, n - 1, n - 1) * (rdiff - 1);
                sum += query(dp, 0, 0, n - 1, n - 1) * (cdiff - 1);
                sum += query(dp, 0, 0, n - 1, c2 % n) * (rdiff - 1);
                sum += query(dp, 0, 0, r1 % n, n - 1) * (cdiff - 1);

            }
            System.out.println(sum);

        }
        out.close();
    }

    private static long query(int[][] dp, int a, int b, int c, int d) {
        int sum = dp[c][d];
        if (a > 0) sum -= dp[a - 1][d];
        if (b > 0) sum -= dp[c][b - 1];
        if (a > 0 && b > 0) sum += dp[a - 1][b - 1];
        return sum;
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

