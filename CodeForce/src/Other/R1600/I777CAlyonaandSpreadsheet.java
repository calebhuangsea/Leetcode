package Other.R1600;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I777CAlyonaandSpreadsheet {
    /**
     * Time: O(MN)
     * Space: O(MN)
     * @param args
     */
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[n][m];
        // dp[i][j] = from i to j there exist an increasing subsequence
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            // column j
            // try to find every x,y interval that satisfies
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1][j] <= arr[i][j]) {
                    // satisfy, increase count
                    count += 1;
                    dp[i] = Math.max(dp[i], count);
                } else {
                    count = 1;
                }
            }
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
            int diff = r - l + 1;
            if (diff <= dp[r]) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.close();
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

