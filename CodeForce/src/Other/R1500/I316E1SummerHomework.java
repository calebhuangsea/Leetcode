package Other.R1500;

import java.io.*;
import java.util.StringTokenizer;

public class I316E1SummerHomework {
    public static void main(String[] args) {
        int mod = (int)1e9;
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                a[sc.nextInt()] = sc.nextInt();
            } else if (op == 2) {
                int l = sc.nextInt();
                int diff = sc.nextInt() - l;
                long f0 = 1;
                long f1 = 1;
                long sum = a[l];
                for (int j = 1; j <= diff; j++) {
                    sum += f1 * a[l + j];
                    sum %= mod;
                    long temp = f0 + f1;
                    temp %= mod;
                    f0 = f1;
                    f1 = temp;
                }
                System.out.println(sum);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int d = sc.nextInt();
                for (l = l; l <= r; l++) {
                    a[l] += d;
                    a[l] %= mod;
                }
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

