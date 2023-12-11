package Other.R1700;

import java.io.*;
import java.util.StringTokenizer;

public class I1528BKavionPairingDuty {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        long mod = 998244353;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j+=i) {
                dp[j]++;
            }
        }
        dp[1] = 1;
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i] + sum) % mod;
            sum += dp[i];
            sum %= mod;
        }
        out.println((dp[n]) % mod);
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

