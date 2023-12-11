package Beginner.R331;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int N = sc.nextInt(), S = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt();
        // dp[i] = minimum to buy this
        int[] dp = new int[120];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[6] = S;
        dp[8] = M;
        dp[12] = L;
        for (int i = 12; i < 120; i++) {
            dp[i] = Math.min(dp[i], dp[i - 6] + S);
            dp[i] = Math.min(dp[i], dp[i - 8] + M);
            dp[i] = Math.min(dp[i], dp[i - 12] + L);
        }
        int min = Integer.MAX_VALUE;
        for (int i = N; i <= 119; i++) {
            min = Math.min(min, dp[i]);
        }
        System.out.println(min);

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

